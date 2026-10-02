package com.pioneers.rest.exampleforme.controllers.models.di;

import com.pioneers.rest.exampleforme.controllers.models.di.ex.ClassEnum;
//import com.pioneers.rest.models.di.ex.ClassSingle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // الطريقة القياسية لتشغيل سيرفر الويب
        SpringApplication.run(Main.class, args);
//        ClassSingle classSingle1 = ClassSingle.getINSTANCE();
//        ClassSingle classSingle2 = ClassSingle.getINSTANCE();
//System.out.println(classSingle1 == classSingle2);

        ClassEnum classSingle1 = ClassEnum.INSTANCE;
        ClassEnum classSingle2 = ClassEnum.INSTANCE;
        System.out.println(classSingle1 == classSingle2);
    }
}