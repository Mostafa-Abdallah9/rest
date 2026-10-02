package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentDelegator3 {

    private static final String CLASS_NAME = PaymentDelegator2.class.getSimpleName();

    private final ApplicationContext applicationContext;

    public PaymentDelegator3(ApplicationContext applicationContext){

        log.info(" PaymentDelegator2 [{}} " , CLASS_NAME);

        this.applicationContext = applicationContext;
    }

    public void pay(final String beanName,final double amount) {
        final Payment payment;
        try {
            payment = applicationContext.getBean(beanName, Payment.class);
        } catch (Exception e) {
            throw new PaymentType.PaymentException(
                    "Payment type not found: " + beanName
            );
        }

        payment.pay(amount);
    }

}
