package com.pioneers.rest.exampleforme.controllers.models.di.ex.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/scopes")
public class ScopeController2 {
    private final ObjectProvider<ScopeExample> scopeExample;

    public ScopeController2(ObjectProvider<ScopeExample> scopeExample) {
        this.scopeExample = scopeExample;
    }

    @GetMapping("/application")
    public UUID checkApplication() {
        return scopeExample.getObject().getUUID_Number();
    }
}
