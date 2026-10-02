package com.pioneers.rest.exampleforme.controllers.models.di.ex.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/scopes")
public class ScopeController {
    private final ObjectProvider<ScopeExample> scopeExample;

    public ScopeController(ObjectProvider<ScopeExample> scopeExample) {
        this.scopeExample = scopeExample;
    }

    @GetMapping
    public void check() throws ArithmeticException {
//        return scopeExample.getObject().getUUID_Number();

//        scopeExample.ifAvailable((n) -> {
//            log.info("mmmmmmmm [{}", n.getUUID_Number());
//        });

//        return scopeExample.getIfAvailable(()->{
//            throw new ArithmeticException("this is bean is not found");}).getUUID_Number();

         scopeExample.forEach((n)->n.getUUID_Number());
    }
}
