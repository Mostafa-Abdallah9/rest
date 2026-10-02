package com.pioneers.rest.exampleforme.controllers.models.di.ex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ClassB classB;

    public TestController(ClassB classB) {
        this.classB = classB;
    }

    @GetMapping("/test")
    public ClassA test() {
        return classB.getClassA();
    }
}
