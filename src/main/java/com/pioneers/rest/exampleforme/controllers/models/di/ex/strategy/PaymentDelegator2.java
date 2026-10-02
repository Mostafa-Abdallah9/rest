package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PaymentDelegator2 {
    private static final String CLASS_NAME = PaymentDelegator2.class.getSimpleName();

    private final List<Payment> payments;

    public PaymentDelegator2(List<Payment> payments) {
        log.info(" PaymentDelegator2 [{}} " , CLASS_NAME);

        this.payments = payments;

//        payments.forEach(payment ->
//                log.info("Bean = {}, Type = {}",
//                        payment.getClass().getSimpleName(),
//                        payment.getType())
//        );

        payments.forEach(payment ->
                System.out.println(payment.getClass().getSimpleName()
                        + " -> " + payment.getType())
        );

    }

    public void pay(final String type,final double amount) {
        final Payment payment =  payments.stream()
//                .sorted((a1,a2)->a1.getType().compareTo(a2.getType()))
                .filter(n->n.getType().hasType(type))
                .findFirst()
                .orElseThrow(()-> {
                    throw new PaymentType.PaymentException("NOT FOUND");
                });
        payment.pay(amount);
    }

    public List<Payment> getPayments() {
        return payments;
    }

}
