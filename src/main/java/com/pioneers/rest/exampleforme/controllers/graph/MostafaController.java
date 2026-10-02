package com.pioneers.rest.exampleforme.controllers.graph;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/mostafa/{id}")
@RequiredArgsConstructor
public class MostafaController {
    private final StudentService studentService;

    @GetMapping
    public Studentt getStudentById(@PathVariable UUID id) {
        return studentService.findById(id);
    }


}
