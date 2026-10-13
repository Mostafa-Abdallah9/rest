package com.pioneers.rest.amaan.models.dtos.requests;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TerminalEnrollmentRequestDto(
        @NotBlank(message = "Terminal ID cannot be blank")
         String terminalId,
        @NotBlank(message = "Service Code cannot be blank")
         String serviceCode,
         String deviceModel,
         BigDecimal recurringAmount,
         LocalDateTime timestamp
) {
}
