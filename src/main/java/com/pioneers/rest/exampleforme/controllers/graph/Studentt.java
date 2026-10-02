package com.pioneers.rest.exampleforme.controllers.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Studentt {
    private final UUID id;
    private final String firstName;
    private final String secondName;
    private final int age;
    private final String email;
}

