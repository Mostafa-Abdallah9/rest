package com.pioneers.rest.amaan.errors.handlers;

import com.pioneers.rest.amaan.errors.exceptions.*;
import com.pioneers.rest.amaan.errors.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(DeviceNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse<?> handleDeviceNotSupported(final DeviceNotSupportedException e) {
        log.error("DeviceNotSupportedException: {}", e.getMessage());
        return new ErrorResponse<>(
                DeviceNotSupportedException.CODE,
                DeviceNotSupportedException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(DuplicateSubscriptionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse<?> handleDuplicateSubscription(final DuplicateSubscriptionException e) {
        log.error("DuplicateSubscriptionException: {}", e.getMessage());
        return new ErrorResponse<>(
                DuplicateSubscriptionException.CODE,
                DuplicateSubscriptionException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(ExternalServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse<?> handleExternalService(final ExternalServiceException e) {
        log.error("ExternalServiceException: {}", e.getMessage());
        return new ErrorResponse<>(
                ExternalServiceException.CODE,
                ExternalServiceException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(ServiceConfigurationNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse<?> handleServiceConfigNotFound(final ServiceConfigurationNotFoundException e) {
        log.error("ServiceConfigurationNotFoundException: {}", e.getMessage());
        return new ErrorResponse<>(
                ServiceConfigurationNotFoundException.CODE,
                ServiceConfigurationNotFoundException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(TerminalNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse<?> handleTerminalNotFound(final TerminalNotFoundException e) {
        log.error("TerminalNotFoundException: {}", e.getMessage());
        return new ErrorResponse<>(
                TerminalNotFoundException.CODE,
                TerminalNotFoundException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }
}

