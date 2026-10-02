package com.pioneers.rest.function_programming;

import com.pioneers.rest.function_programming.nn.StudentRegister;
import com.pioneers.rest.function_programming.nn.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        final StudentRegister studentRegister = new StudentRegister("mostafa",2);
        final StudentService studentService = context.getBean(StudentService.class);
        studentService.apply(studentRegister,()->System.out.println("Student registered successfully"));

    }
}
