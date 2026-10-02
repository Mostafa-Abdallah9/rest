package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AnimalProcessor3 {

    private final Map<Animal,AnimalService> animalServices;

    @Autowired
    private AnimalProcessor3(List<AnimalService> animalServices) {
        this.animalServices = Arrays.stream(Animal.values())
                .collect(Collectors.toUnmodifiableMap(
                        animal -> animal,
                        animal -> getFirstAnimalService(animalServices, animal)
                                .orElseThrow(() -> new IllegalStateException(
                                        "No AnimalService found for animal type: " + animal
                                ))
                ));
    }
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

    public Optional<AnimalService> getFirstAnimalService(final List<AnimalService> animalServices, final Animal animal){
        return
                animalServices
                        .stream()
                        .filter(animalService -> animalService.isTypeAligned(animal))
                        .findFirst();
    }
}
