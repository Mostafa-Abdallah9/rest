package com.pioneers.rest.exampleforme.controllers.models.di.configs;

import com.pioneers.rest.exampleforme.controllers.models.di.PremiumSpellChecker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value(value = "${spell.checker.ownerName}")
    private  String ownerName;

    @Value(value = "${spell.checker.version}")
    private  String version;
@Bean
    public PremiumSpellChecker bb () {
    System.out.println("premium spell checker " + ownerName + " " + version);
    return new PremiumSpellChecker("mostafa desokey","v1.1");
}

}
