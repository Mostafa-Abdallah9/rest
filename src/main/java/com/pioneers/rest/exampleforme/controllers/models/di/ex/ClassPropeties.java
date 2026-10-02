package com.pioneers.rest.exampleforme.controllers.models.di.ex;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Objects;

@ConfigurationProperties(prefix = "most")
public record ClassPropeties(String fName, String fPassword) {



}
