package com.pioneers.rest.exampleforme.controllers.models.di.ex.strategy;

public interface Payment {

    PaymentType getType();

    void pay(double amount);

}
