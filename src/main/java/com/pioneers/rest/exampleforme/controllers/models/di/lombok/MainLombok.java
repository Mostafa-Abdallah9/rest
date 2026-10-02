package com.pioneers.rest.exampleforme.controllers.models.di.lombok;

import com.pioneers.rest.exampleforme.controllers.models.di.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainLombok {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//         Address address = new Address("1","Mostafa","Desokey","Egypt","parada","masged el abasey");
//        Address address = new Address();
//        address.setId("1");
//        address.setFName("Mostafa");
//        address.setLName("Desokey");
//        address.setCountry("Egypt");
//        address.setCity("parada");
//        address.setStreet("masged el abasey");
//         System.out.println(address);
        int x =2;
        switch (x) {
            case 1:
                System.out.println("a");
            case 2 :
                System.out.println("b");
            case 3:
                System.out.println("c");

        }
    }
}
