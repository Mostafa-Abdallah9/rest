//package com.pioneers.rest.task.graph;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import java.util.UUID;
//
//@Controller
//@RequiredArgsConstructor
//public class StudentGraphQLController {
//    private final StudentService studentService;
//
//    @QueryMapping
//    public Studentt getStudentById(@Argument UUID id) {
//        return studentService.findById(id);
//    }
//
//    @MutationMapping
//    public StudenttResponse changeSecondName(
//            @Argument UUID id,
//            @Argument String secondName
//    ) {
//        return studentService.changeSecondName(id, secondName);
//    }
//
//    @MutationMapping
//    public StudenttResponse changeFirstName(
//            @Argument UUID id,
//            @Argument String firstName
//    ) {
//        return studentService.changeFirstName(id, firstName);
//    }
//}
