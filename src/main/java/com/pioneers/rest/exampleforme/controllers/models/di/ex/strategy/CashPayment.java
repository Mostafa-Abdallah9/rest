package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;

//@Component("cashPayment")
@Slf4j
public class CashPayment implements Payment {

    private static final String className =CashPayment.class.getSimpleName();

    public CashPayment() {
        log.info("generated CashPayment [{}] ",className);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }

    @Override
    public void pay(double amount) {
        log.info("Paying with cash: " + amount);
    }
}
