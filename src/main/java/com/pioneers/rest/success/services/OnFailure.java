package com.pioneers.rest.success.services;

@FunctionalInterface
public interface OnFailure {
    String onFailure(String message);

}
