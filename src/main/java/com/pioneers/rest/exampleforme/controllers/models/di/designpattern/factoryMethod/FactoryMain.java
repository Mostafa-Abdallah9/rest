package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.factoryMethod;

public class FactoryMain {

    public static void main(String[] args) {

       final Shape factoryMain = FactoryShape.getShape(null);

        factoryMain.draw();

//        System.out.println(factoryMain);

    }

}
