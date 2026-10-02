package com.pioneers.rest.exampleforme.controllers.models.di.ex.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@Lazy
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
//@Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope("WebApplicationContext.SCOPE_GLOBAL_SESSION")
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class ScopeExample {
    private  final UUID UUID_Number = java.util.UUID.randomUUID();
    public ScopeExample() {
        log.info("ScopeExample created: {}", UUID_Number);
    }

    public UUID getUUID_Number() {
        return UUID_Number;
    }
}
