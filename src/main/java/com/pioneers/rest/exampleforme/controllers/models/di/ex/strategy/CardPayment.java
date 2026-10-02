package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;

//@Component("cardPayment")
@Slf4j

public class CardPayment implements Payment {

    private static final String className =CardPayment.class.getSimpleName();

    public CardPayment() {
        log.info("generated CardPayment [{}] ",className);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }

    @Override
    public void pay(double amount) {
        log.info("Paying with card: " + amount);
    }

}
