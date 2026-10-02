package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentDelegator1 {
    private static final String CLASS_NAME = PaymentDelegator1.class.getSimpleName();

    private final Payment payment;

    private PaymentDelegator1(Payment cashPayment) {
        log.info(" PaymentDelegator1 [{}} " , CLASS_NAME);
        this.payment = cashPayment;
    }

    public void pay(final String beanName,final double amount) {

        if (!payment.getType().hasType(beanName)) {
            throw new PaymentType.PaymentException("this is type is NOT FOUND");
        }

        payment.pay(amount);
    }


}
