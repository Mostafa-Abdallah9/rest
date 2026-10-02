package com.pioneers.rest.exampleforme.controllers.models.di.ex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ClassB {

 private final ClassA classA;
   @Autowired
    public ClassB(@Qualifier(value = "classA2") ClassA classA) {
       final String nameConstructor = "ClassB";
       log.debug("[{}],CLASSAAAAAAA",nameConstructor);
        this.classA = classA;
    }

    public ClassA getClassA() {
        return classA;
    }
}
