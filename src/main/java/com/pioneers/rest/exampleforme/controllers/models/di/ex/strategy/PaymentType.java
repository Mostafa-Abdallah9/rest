package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PaymentType {

    CASH("CASH"),
    CARD("CARD"),
    PAYPAL("PAYPAL");

    private final String paymentType;

    public boolean hasType(final String type) {
        return paymentType.equalsIgnoreCase(type);
    }


    public static PaymentType fromType(final String typeString) throws PaymentException {
        return Arrays.stream(PaymentType.values())
                .filter(type->type.getPaymentType().equalsIgnoreCase(typeString))
                .findFirst()
                .orElseThrow(()-> new PaymentException("this is type is not found"));
     }

    public static class PaymentException extends RuntimeException {
        public PaymentException(String message) {
            super(message);
        }
    }
}


