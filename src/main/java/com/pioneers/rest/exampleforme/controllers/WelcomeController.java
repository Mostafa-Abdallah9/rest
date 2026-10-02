//package com.pioneers.rest.controllers;
//
//import com.pioneers.rest.models.dtos.requests.Studentt;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("welcome")
//public class WelcomeController {

//    @GetMapping("mostafa")
//    public String getWelcome(final String name) {
//        return "<h1>welcome mostafa to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student/{name}")
//    public String getWelcome(@PathVariable String studentname) {
//        return "<h1>welcome " + studentname + " to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student/{name}")
//    public String getWelcome(@PathVariable(name = "name") String studentname) {
//        return "<h1>welcome " + studentname + " to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student/{name}")
//    public String getWelcome(@PathVariable(required = true) String studentname) {
//        return "<h1>welcome " + studentname + " to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student")
//    public String getWelcomeWithRequestParam(@RequestParam( name = "name") String studentname) {
//        return "<h1>welcome " + studentname + " to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student")
//    public String getWelcomeWithRequestParam(@RequestParam( value = "name") String studentname) {
//        return "<h1>welcome " + studentname + " to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student")
//    public String getWelcomeWithRequestParam(@RequestParam( required = false) String studentname) {
//        return "<h1>welcome " + studentname + " to learn spring in my diploma</h1>";
//    }

//    @GetMapping("student")
//    public String getWelcomeWithRequestParam(@RequestBody() Studentt student) {
//        return "<h1>welcome " + student.getName() +
//                " to learn spring in my diploma with age"
//                +student.getAge()+"</h1>";
//    }
//}
