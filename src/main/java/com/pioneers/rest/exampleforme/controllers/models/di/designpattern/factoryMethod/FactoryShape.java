package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.factoryMethod;

public class FactoryShape {

    public static Shape getShape(final String type) throws IllegalArgumentException {

        if ("circle".equalsIgnoreCase(type)) {
            return new Circle();

        }

        if ("Rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        }

        throw new IllegalArgumentException("not found");
    }
}
