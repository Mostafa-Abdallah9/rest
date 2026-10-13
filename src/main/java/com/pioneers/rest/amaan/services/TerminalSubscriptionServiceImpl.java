package com.pioneers.rest.amaan.services;

import com.pioneers.rest.amaan.errors.exceptions.DeviceNotSupportedException;
import com.pioneers.rest.amaan.errors.exceptions.DuplicateSubscriptionException;
import com.pioneers.rest.amaan.errors.exceptions.ServiceConfigurationNotFoundException;
import com.pioneers.rest.amaan.errors.exceptions.TerminalNotFoundException;
import com.pioneers.rest.amaan.models.dtos.requests.TerminalEnrollmentRequestDto;
import com.pioneers.rest.amaan.models.dtos.responses.TerminalEnrollmentResponseDto;
import com.pioneers.rest.amaan.models.entities.ServiceConfiguration;
import com.pioneers.rest.amaan.models.entities.TerminalSubscription;
import com.pioneers.rest.amaan.repositories.ServiceConfigurationRepository;
import com.pioneers.rest.amaan.repositories.TerminalSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TerminalSubscriptionServiceImpl
        implements TerminalSubscriptionService {

    private final TerminalSubscriptionRepository terminalSubscriptionRepository;
    private final ServiceConfigurationRepository serviceConfigurationRepository;
    private final BillPaymentGleClient billPaymentGleClient;

    @Override
    public TerminalEnrollmentResponseDto enrollTerminalToService(
            TerminalEnrollmentRequestDto requestDto) {

        log.info(
                "Initiating enrollment for terminal {} and service {}",
                requestDto.terminalId(),
                requestDto.serviceCode()
        );

        // 1. Validate terminal in GLE
        boolean terminalExists =
                billPaymentGleClient.checkTerminalExists(requestDto.terminalId());

        if (!terminalExists) {
            throw new TerminalNotFoundException(
                    "Terminal ID " + requestDto.terminalId() + " does not exist."
            );
        }

        // 2. Find active service
        ServiceConfiguration serviceConfig =
                serviceConfigurationRepository
                        .findByServiceCodeAndActive(
                                requestDto.serviceCode(), true
                        )
                        .orElseThrow(() ->
                                new ServiceConfigurationNotFoundException(
                                        "Active service configuration not found: "
                                                + requestDto.serviceCode()
                                )
                        );

        // 3. Validate device model
        validateDeviceModelWhitelist(
                requestDto.deviceModel(),
                serviceConfig
        );

        // 4. Validate recurring amount
        BigDecimal recurringAmount =
                requestDto.recurringAmount() != null
                        ? requestDto.recurringAmount()
                        : serviceConfig.getDefaultRecurringAmount();

        if (recurringAmount == null
                || recurringAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Recurring amount must be greater than zero."
            );
        }

        // 5. Check active duplicate and save
        TerminalSubscription savedSubscription =
                saveSubscription(requestDto, serviceConfig, recurringAmount);

        log.info(
                "Successfully enrolled terminal {} to service {}",
                savedSubscription.getTerminalId(),
                savedSubscription.getServiceCode()
        );

        return toEnrollmentResponseDto(savedSubscription);
    }

    private void validateDeviceModelWhitelist(
            String deviceModel,
            ServiceConfiguration serviceConfig) {

        if (serviceConfig.getWhitelistedDeviceModels() != null
                && !serviceConfig.getWhitelistedDeviceModels().isEmpty()
                && (deviceModel == null
                || !serviceConfig.getWhitelistedDeviceModels()
                .contains(deviceModel))) {

            throw new DeviceNotSupportedException(
                    "Device model " + deviceModel
                            + " is not supported for this service."
            );
        }
    }

    @Transactional
    protected TerminalSubscription saveSubscription(
            TerminalEnrollmentRequestDto requestDto,
            ServiceConfiguration serviceConfig,
            BigDecimal recurringAmount) {

        boolean activeSubscriptionExists =
                terminalSubscriptionRepository
                        .existsByTerminalIdAndServiceCodeAndSubscriptionActiveTrue(
                                requestDto.terminalId(),
                                serviceConfig.getServiceCode()
                        );

        if (activeSubscriptionExists) {
            throw new DuplicateSubscriptionException(
                    "Terminal is already subscribed to this service."
            );
        }

        TerminalSubscription subscription = TerminalSubscription.builder()
                .terminalId(requestDto.terminalId())
                .serviceCode(serviceConfig.getServiceCode())
                .joinDate(LocalDateTime.now())
                .nextDueDate(
                        LocalDate.now().plusDays(
                                serviceConfig.getRecurringPeriodDays()
                        )
                )
                .recurringAmount(recurringAmount)
                .outstandingArrears(BigDecimal.ZERO)
                .subscriptionActive(true)
                .build();

        return terminalSubscriptionRepository.save(subscription);
    }

    private TerminalEnrollmentResponseDto toEnrollmentResponseDto(
            TerminalSubscription subscription) {

        return TerminalEnrollmentResponseDto.builder()
                .terminalId(subscription.getTerminalId())
                .serviceCode(subscription.getServiceCode())
                .status("SUCCESS")
                .message(
                        "Terminal successfully enrolled to maintenance insurance service."
                )
                .build();
    }
}