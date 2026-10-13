package com.pioneers.rest.amaan.services;

import com.pioneers.rest.amaan.errors.exceptions.ExternalServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class BillPaymentGleClient {

    private final RestTemplate restTemplate;
    private static final String GLE_CHECK_TERMINAL_URL = "http://gle-service/api/v1/terminals/{terminalId}/exists";

    public boolean checkTerminalExists(final String terminalId) {
        return true;
    }

//    public boolean checkTerminalExists(final String terminalId) throws ExternalServiceException {
//        try {
//            final Boolean exists = restTemplate.getForObject(GLE_CHECK_TERMINAL_URL, Boolean.class, terminalId);
//            return Boolean.TRUE.equals(exists);
//        } catch (ExternalServiceException e) {
//            log.error("Failed to connect to GLE service for terminal validation. Terminal ID: {}", terminalId, e);
//            throw new ExternalServiceException("Unable to validate terminal existence due to an error in the GLE service: " + e.getMessage());        }
//    }
}