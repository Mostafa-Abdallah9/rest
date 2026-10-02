package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("catStrategy")
public class CatStrategy implements AnimalService {
    private static final Animal CAT = Animal.CAT;

    public CatStrategy() {
        log.debug("CatStrategy bean constructed [{}]", CAT.getClass().getSimpleName());
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return CAT.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕");
    }

    @Override
    public void makeSound() {
        log.info("🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮");
    }

}
