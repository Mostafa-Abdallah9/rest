package com.pioneers.rest.exampleforme.controllers.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudenttResponse {
    private String firstName;
    private String secondName;
    private int age;
}
