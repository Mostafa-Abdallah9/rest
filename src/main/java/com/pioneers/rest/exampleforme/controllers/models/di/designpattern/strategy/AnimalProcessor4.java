package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AnimalProcessor4 {

    private final ApplicationContext applicationContext;

    @Autowired
    public AnimalProcessor4(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;

    }

    public void feedAnimal(final List<AnimalService> animalServices,final Animal animal) throws Animal.AnimalException {

    }

    public void makeSound(final List<AnimalService> animalServices,final Animal animal) throws Animal.AnimalException {

    }

}
