package com.pioneers.rest.exampleforme.controllers.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@EqualsAndHashCode(callSuper = false)
public class MostafaException extends RuntimeException {
    public static final int CODE = 1000;
    public static final String message = "noooot fooound";
    private final String description ;
    private final Timestamp timestamp = Timestamp.from(Instant.now());
    public MostafaException(String description) {
        super(description);
        this.description =description;
    }
}
