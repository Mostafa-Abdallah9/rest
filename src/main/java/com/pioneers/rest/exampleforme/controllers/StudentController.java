//package com.pioneers.rest.controllers;
//
//import com.pioneers.rest.models.dtos.requests.StudentLogin;
//import com.pioneers.rest.models.dtos.requests.StudentRegister;
//import com.pioneers.rest.models.dtos.requests.UpdateStudent;
//import com.pioneers.rest.models.dtos.responses.StudentResponse;
//import com.pioneers.rest.models.entites.Studentt;
//import com.pioneers.rest.services.StudentService;
//import com.pioneers.rest.utils.mappers.StudentMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//import static com.pioneers.rest.services.StudentService.*;
//import static com.pioneers.rest.utils.mappers.StudentMapper.toStudentResponse;
//import static com.pioneers.rest.utils.validators.StudentValidation.validateStudentRegisterRequest;
//
//@RestController
//@RequestMapping("Studentt")
//public class StudentController {
//
//    @GetMapping("findAllSucceededStudents")
//    public ResponseEntity<?> findAllSucceededStudentsApi() {
//        final Collection<Studentt> succeededStudents = findAllSucceeded();
//        if (succeededStudents.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No succeeded students found");
//        }
//        final Collection<StudentResponse> succeededStudentsResponse = succeededStudents.stream()
//                .map(StudentMapper::toStudentResponse)
//                .toList();
//        return ResponseEntity.ok(succeededStudentsResponse);
//    }
//
//    @GetMapping("findById/{id}")
//    public ResponseEntity<?> findByIdApi(@PathVariable UUID id) {
//        final Optional<Studentt> optionalFoundStudent = findById(id);
//        if (optionalFoundStudent.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studentt not found");
//        }
//        final StudentResponse studentResponse = toStudentResponse(optionalFoundStudent.get());
//
//        return ResponseEntity.ok(studentResponse);
//
//    }
//
//    @GetMapping("findAll")
//    public ResponseEntity<?> findAllStudentsApi() {
//        final Collection<Studentt> sortedStudentsByAge = findAllSortByAge();
//        if (sortedStudentsByAge.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Db is empty");
//        }
//
//        final Collection<StudentResponse> studentResponses = sortedStudentsByAge
//                .stream()
//                .map(StudentMapper::toStudentResponse)
//                .toList();
//        return ResponseEntity.ok(studentResponses);
//
//    }
//
//    @PostMapping("set")
//    public ResponseEntity<?> setLogInWithStudent(@RequestBody StudentLogin studentLogin) {
//        if (STUDENT_DB.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Optional<Studentt> optionalStudent = StudentService.findByEmail(studentLogin.getEmail());
//
//        if (optionalStudent.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Studentt student = optionalStudent.get();
//
//        if (!StudentService.isPasswordCorrect(studentLogin.getPassword(), student)) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(StudentService.loggedInStudent = student);
//
//    }
//
//    @PutMapping("update/{id}")
//    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody UpdateStudent updateStudent) {
//        return ResponseEntity.ok(StudentService.update(id, updateStudent));
//    }
//
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<?> deleta(@PathVariable UUID id) {
//        final Optional<Studentt> optionalStudent = findById(id);
//        if (optionalStudent.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studentt not found");
//        }
//        deleta(id);
//        return ResponseEntity.ok("Successfully deleted student with email: " + optionalStudent.get().getEmail());
//    }
//
//    @DeleteMapping("deleteAll")
//    public ResponseEntity<?> deletaAll() {
//        StudentService.deleteAll();
//        return ResponseEntity.ok().body("Successfully deleted all students");
//    }
//
//}
//
//
//
//
