package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PaymentDelegator4 {

    private final Map<PaymentType,Payment> payments;

    public PaymentDelegator4(Set<Payment> paymentSet) {

        this.payments = Arrays.stream(PaymentType.values())
                .collect(Collectors.toUnmodifiableMap(type->type,
                        type->
                                paymentSet.stream().
                                        filter(payment -> payment.getType().hasType(type.getPaymentType()))
                                        .findFirst()
                                        .orElseThrow(()-> new PaymentType.PaymentException("notttt fooooount"))));

    }

    public void pay(final String type,final double amount) throws PaymentType.PaymentException {
        PaymentType paymentType = PaymentType.fromType(type);
        Optional.ofNullable(payments.get(paymentType)).ifPresentOrElse(payment -> {
            payment.pay(amount);
        },()->new PaymentType.PaymentException("notttt fooooount"));

    }


}
