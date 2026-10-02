package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("zebraStrategy")
public class ZebraStrategy implements AnimalService {
    private static final Animal ZEBRA = Animal.ZEBRA;

    public ZebraStrategy() {
        log.debug("ZebraStrategy bean constructed [{}]",ZEBRA.getClass().getSimpleName());
    }

    @Override
    public boolean isTypeAligned(final Animal animal) {
        return ZEBRA.hasType(animal);
    }

    @Override
    public void feed() {
        log.info("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
    }

    @Override
    public void makeSound() {
        log.info("🦓🦓🦓🦓🦓🦓🦓🦓🦓🦓🦓🦓");
    }

}
