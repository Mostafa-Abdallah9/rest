package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("lionStrategy")
public class LionStrategy implements AnimalService {
    private static final Animal LION = Animal.LION;

    public LionStrategy() {
        log.debug("LionStrategy bean constructed [{}]",LION.getClass().getSimpleName());
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return LION.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗");
    }

    @Override
    public void makeSound() {
        log.info("🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁");
    }
}
