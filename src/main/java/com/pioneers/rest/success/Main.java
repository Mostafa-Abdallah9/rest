package com.pioneers.rest.success;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Main main = new Main();
        main.myMethod();
    }
        public void myMethod() {

            long start = System.nanoTime();

            // code
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }

            long end = System.nanoTime();

            System.out.println("Execution time: " + (end - start) / 1_000_000.0 + " ms"
            );
        }

}
