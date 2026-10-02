//package com.pioneers.rest.controllers;
//
//import com.pioneers.rest.models.dtos.requests.User;
//import com.pioneers.rest.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.LinkedList;
//
//@RestController
//@RequestMapping("User")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("signup")
//    public LinkedList<User> register(@RequestBody User user) {
//        return userService.signup(user);
//    }
//
//    @PostMapping("login")
//    public User logIn(@RequestParam String password, @RequestParam String email) {
//            return userService.logIn(password, email);
//    }
//}
