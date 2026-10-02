package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("tigerStrategyBean")
public class TigerStrategy implements AnimalService {
    private static final Animal TIGER = Animal.TIGER;

    public TigerStrategy() {
        log.debug("TigerStrategy bean constructed [{}]",TIGER.getClass().getSimpleName());
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return TIGER.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🐷🐷🐷🐷🐷🐷🐷🐷🐷🐷🐷🐷");
    }

    @Override
    public void makeSound() {
        log.info("🐅🐅🐅🐅🐅🐅🐅🐅🐅🐅🐅🐅");
    }
}
