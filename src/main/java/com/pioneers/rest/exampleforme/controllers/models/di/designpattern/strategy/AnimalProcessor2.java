package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnimalProcessor2 {
    private final List<AnimalService> animalServices;

    public void feedAnimal(final List<AnimalService> animalServices,final Animal animal) throws Animal.AnimalException {
        getFirstAnimalService(animalServices,animal)
                .ifPresentOrElse(AnimalService::feed,()->{
                    throw new Animal.AnimalException("this is animal is not found");
                });
    }

    public void makeSound(final List<AnimalService> animalServices,final Animal animal) throws Animal.AnimalException {
        getFirstAnimalService(animalServices,animal)
                .ifPresentOrElse(AnimalService::feed,()->{
                    throw new Animal.AnimalException("this is animal is not found");
                });
    }

public Optional<AnimalService> getFirstAnimalService(final List<AnimalService> animalServices,final Animal animal){
    return
            animalServices
                    .stream()
                    .filter(animalService -> animalService.isTypeAligned(animal))
                    .findFirst();
}
}
