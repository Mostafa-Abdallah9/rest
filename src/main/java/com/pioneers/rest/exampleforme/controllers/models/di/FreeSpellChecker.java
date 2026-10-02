package com.pioneers.rest.exampleforme.controllers.models.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FreeSpellChecker implements SpellChecker {
    private final String beanName = "freeSpellChecker";

    @Override
    public String getBeanName() {
        return beanName;
    }
}
