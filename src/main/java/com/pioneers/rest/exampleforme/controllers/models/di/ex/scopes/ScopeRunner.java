//package com.pioneers.rest.models.di.ex.scopes;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ScopeRunner {
//    private final ApplicationContext context;
//
//    public ScopeRunner(ApplicationContext context) {
//        this.context = context;
//        test();
//    }
//
//    public void test() {
//
//        ScopeExample obj1 = context.getBean(ScopeExample.class);
//        ScopeExample obj2 = context.getBean(ScopeExample.class);
//
//        System.out.println(obj1 == obj2);
//    }
//}
