package com.pioneers.rest.exampleforme.controllers.models.di.utility;

public class MainUtility {
    public static void main(String[] args) {
//        UtilityClass utilityClass =
//                new UtilityClass("1","mostafa","desokey","egypt","parada","omar");


        UtilityClass utilityClass = UtilityClass.builder()
                .id("1")
                .fName("mostafa")
                .lName("desokey")
                .build();
        System.out.println(utilityClass);
    }
}
