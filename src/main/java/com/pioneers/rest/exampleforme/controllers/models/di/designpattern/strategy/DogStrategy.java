package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Slf4j
@Repository("dogStrategy")
public class DogStrategy implements AnimalService {
    private static final Animal DOG = Animal.DOG;

    private final UUID currentUUID = UUID.randomUUID();

    public DogStrategy() {
        log.debug("DogStrategy bean constructed [{}]", DOG.getClass().getSimpleName());
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return DOG.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴");
    }

    @Override
    public void makeSound() {
        log.info("🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮");
    }
}
