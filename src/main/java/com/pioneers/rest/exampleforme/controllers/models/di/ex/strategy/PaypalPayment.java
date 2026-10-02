package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;

//@Component("paypalPayment")
@Slf4j
//@Order(1)
public class PaypalPayment implements Payment {

    private static final String className =PaypalPayment.class.getSimpleName();

    public PaypalPayment() {
        log.info("generated PaypalPayment [{}] ",className);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.PAYPAL;
    }

    @Override
    public void pay(double amount) {
        log.info("Paying with PayPal: " + amount);
    }

}
