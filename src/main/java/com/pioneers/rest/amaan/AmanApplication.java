package com.pioneers.rest.amaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmanApplication.class, args);
    }
}