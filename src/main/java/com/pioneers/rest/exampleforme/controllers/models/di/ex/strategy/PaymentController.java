package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentDelegator5 paymentDelegator5;

    public PaymentController(PaymentDelegator5 paymentDelegator5) {
        this.paymentDelegator5 = paymentDelegator5;
    }

    @PostMapping("/{type}/{amount}")
    public ResponseEntity<?> pay(@PathVariable String type, @PathVariable double amount) {

        try {

            paymentDelegator5.pay(type, amount);
            return ResponseEntity.ok().build();

        } catch (PaymentType.PaymentException e) {

            System.out.println(e.getMessage());
            return ResponseEntity.ok().body("this is type is not allowed");

        }

}

//    @GetMapping
//    public List<Payment> getPayments() {
//        return paymentDelegator3.getPayments();
//    }

}