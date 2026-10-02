package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnimalProcessor {

    private final AnimalService animalService;
    private final AnimalService dogAnimalService;

    @Autowired
    public AnimalProcessor(
            @Qualifier("tigerStrategyBean") AnimalService animalService,
            @Qualifier("dogStrategy") AnimalService dogService
    ) {
        this.animalService = animalService;
        this.dogAnimalService = dogService;
    }

    public void feedAnimal() {
        animalService.feed();
    }

    public void makeSound() {
        animalService.makeSound();
    }

    public void feedDog () {
        dogAnimalService.feed();
    }
}

