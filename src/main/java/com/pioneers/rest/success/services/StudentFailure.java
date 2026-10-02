package com.pioneers.rest.success.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentFailure implements OnFailure {
    @Override
    public String onFailure(String message) {
        return "FAILED: " + message;
    }
}
