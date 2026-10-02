package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

public interface AnimalService {
    boolean isTypeAligned(Animal type);

    void feed();

    void makeSound();
}
