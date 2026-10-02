package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class PaymentDelegator5 {
    private final ObjectProvider<Payment> paymentProvider;

    public PaymentDelegator5(ObjectProvider<Payment> paymentProvider) {

        this.paymentProvider = paymentProvider;

    }

    public void pay(final String type, final double amount) throws PaymentType.PaymentException {
//        final Payment payment = paymentProvider.getIfAvailable(()->{
//            throw new  ArithmeticException ("hhhhhhhhhh");
//        });

        final Payment payment = paymentProvider.getIfAvailable(()->{
            throw new  ArithmeticException ("hhhhhhhhhh");
        });

        if (payment == null) {
            throw new PaymentType.PaymentException("Payment not available");

        }
        payment.pay(amount);

//     Payment payment = paymentProvider.stream()
//             .filter(n->n.getType().hasType(type))
//             .findFirst()
//             .orElseThrow(() ->
//                     new PaymentType.PaymentException(
//                             "Payment type not found: " + type
//                     ));
//
//        payment.pay(amount);
    }
}
