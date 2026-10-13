package com.pioneers.rest.amaan.models.dtos.responses;

import lombok.Builder;

@Builder
public record TerminalEnrollmentResponseDto(
        String terminalId,
        String serviceCode,
        String status,
        String message
) {
}
