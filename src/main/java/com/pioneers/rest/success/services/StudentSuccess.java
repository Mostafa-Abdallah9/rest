package com.pioneers.rest.success.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentSuccess implements OnSuccess {

    @Override
    public String onSuccess(String message) {
        return "SUCCESS: " + message;
    }
}
