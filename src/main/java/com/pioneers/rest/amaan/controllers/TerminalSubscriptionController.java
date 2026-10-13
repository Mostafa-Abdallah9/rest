package com.pioneers.rest.amaan.controllers;

import com.pioneers.rest.amaan.models.dtos.requests.TerminalEnrollmentRequestDto;
import com.pioneers.rest.amaan.models.dtos.responses.TerminalEnrollmentResponseDto;
import com.pioneers.rest.amaan.services.TerminalSubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class TerminalSubscriptionController {

    private final TerminalSubscriptionService terminalSubscriptionService;

    @PostMapping("/enroll")
    public ResponseEntity<TerminalEnrollmentResponseDto> enrollTerminal(
            @Valid @RequestBody TerminalEnrollmentRequestDto requestDto) {

        log.info(
                "Received enrollment request for Terminal ID: {} and Service Code: {}",
                requestDto.terminalId(),
                requestDto.serviceCode()
        );

        TerminalEnrollmentResponseDto responseDto =
                terminalSubscriptionService.enrollTerminalToService(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
