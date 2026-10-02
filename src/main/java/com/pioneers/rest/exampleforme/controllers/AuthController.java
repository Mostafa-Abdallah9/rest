//package com.pioneers.rest.controllers;
//
//import com.pioneers.rest.errors.exceptions.CredentialsException;
//import com.pioneers.rest.models.dtos.requests.StudentLogin;
//import com.pioneers.rest.models.dtos.requests.StudentRegister;
//import com.pioneers.rest.models.dtos.responses.GenericResponse;
//import com.pioneers.rest.models.dtos.responses.StudentResponse;
//import com.pioneers.rest.models.entites.Studentt;
//import com.pioneers.rest.utils.mappers.StudentMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static com.pioneers.rest.services.StudentService.*;
//import static com.pioneers.rest.utils.validators.StudentValidation.validateStudentRegisterRequest;
//
//@Controller
//@RequestMapping("auth")
//public class AuthController {
//    @PostMapping("signup")
//    public ResponseEntity<?> registerStudentApi(
//            @RequestBody final StudentRegister studentRegisterRequest
//    ) {
////        final ResponseEntity<List<String>> errorsResponseEntities = validateStudentRegisterRequest(studentRegisterRequest);
//
//        final List<String> errors = errorsResponseEntities.getBody();
//
//        if (!errors.isEmpty()) {
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        final Optional<Studentt> optionalStudent = findByEmail(studentRegisterRequest.getEmail());
//
//        if (optionalStudent.isPresent()) {
//            return ResponseEntity.badRequest().body(List.of("Studentt already registered"));
//        }
//
//        final String fullName =
//                buildFullName(studentRegisterRequest.getFirstName(), studentRegisterRequest.getLastName());
//
//        final String hashedPassword;
//        try {
//            hashedPassword = hashPassword(studentRegisterRequest.getPassword());
//        } catch (CredentialsException e) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        final Studentt student =
//                new Studentt(UUID.randomUUID(), fullName, studentRegisterRequest.getAge(),
//                        studentRegisterRequest.getEmail(), hashedPassword, false, 0.0F, 0.0F);
//
//        save(student);
//
//        return ResponseEntity
//                .ok(List.of("Successfully registered student with email: " + studentRegisterRequest.getEmail()));
//    }
//
//    @PostMapping("login")
//    public ResponseEntity<String> loginApi(@RequestBody StudentLogin studentLoginRequest) {
//        final Optional<Studentt> optionalFoundStudent = findByEmail(studentLoginRequest.getEmail());
//
//        if (optionalFoundStudent.isEmpty()) {
//            return ResponseEntity.badRequest().body("Studentt with email: " + studentLoginRequest.getEmail() + " not registered");
//        }
//
//        final Studentt foundStudent = optionalFoundStudent.get();
//        if (foundStudent.isLoggedIn()) {
//            return ResponseEntity.badRequest().body("Studentt already logged in");
//        }
//
//        final String hashedPassword = hashPassword(studentLoginRequest.getPassword());
//
//        if (!hashedPassword.equals(foundStudent.getPassword())) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Passwords don't match");
//        }
//
//        foundStudent.setLoggedIn(true);
//
//        return ResponseEntity.ok("Studentt with email: " + foundStudent.getEmail() + " logged in successfully!!");
//    }
//
//    @PostMapping("logout")
//    public ResponseEntity<GenericResponse<String>> logoutApi(@RequestParam String email) {
//        final Optional<Studentt> optionalFoundStudent = findByEmail(email);
//
//        if (optionalFoundStudent.isEmpty()) {
//            return ResponseEntity.badRequest().body(new GenericResponse<>("Studentt with email: " + email + " not registered", null));
//        }
//
//        final Studentt foundStudent = optionalFoundStudent.get();
//
//        if (!foundStudent.isLoggedIn()) {
//            return ResponseEntity.badRequest().body(new GenericResponse<>("Studentt not logged in", null));
//        }
//
//        foundStudent.setLoggedIn(false);
//
//        return ResponseEntity.ok(new GenericResponse<>("Successfully logged out!", null));
//    }
//
//    @PostMapping("saveAll")
//    public ResponseEntity<?> saveAllApi(@RequestBody List<StudentRegister> studentRegisterRequests) {
//        final List<Studentt> registeredStudents = new ArrayList<>();
//
//        studentRegisterRequests.forEach(request -> {
//            Optional<Studentt> optionalStudent = findByEmail(request.getEmail());
//            if (optionalStudent.isPresent()) {
//                registeredStudents.add(optionalStudent.get());
//                return;
//            }
//            registerStudentApi(request);
//        });
//
//        if (registeredStudents.isEmpty()) {
//            return ResponseEntity.ok("Successfully all registeredStudents successfully!");
//        }
//
//        final List<StudentResponse> rejectedStudentsList = registeredStudents.stream()
//                .map(StudentMapper::toStudentResponse)
//                .toList();
//
//        final GenericResponse<List<StudentResponse>> genericResponse =
//                new GenericResponse<>("Those list are rejected to be inserted", rejectedStudentsList);
//
//        return ResponseEntity.ok().body(genericResponse);
//    }
//}