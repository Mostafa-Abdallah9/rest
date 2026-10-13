package com.pioneers.rest.amaan.services;

import com.pioneers.rest.amaan.models.dtos.requests.TerminalEnrollmentRequestDto;
import com.pioneers.rest.amaan.models.dtos.responses.TerminalEnrollmentResponseDto;

public interface TerminalSubscriptionService {

    TerminalEnrollmentResponseDto enrollTerminalToService(TerminalEnrollmentRequestDto terminalEnrollmentRequestDto);

}
