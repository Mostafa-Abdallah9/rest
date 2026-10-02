package com.pioneers.rest.task.controllers;

import com.pioneers.rest.task.models.dtos.requests.StudentUpdate;
import com.pioneers.rest.task.models.dtos.responses.StudentResponse;
import com.pioneers.rest.task.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    // TODO: I need respond back to the client with each HTTP Status
    @GetMapping("findAll")
    public List<StudentResponse> findAllStudentsApi() {
        return studentService.findAllSortedByAge();
    }

    @GetMapping("findById/{id}")
    public StudentResponse findByIdApi(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @GetMapping("findAllSucceededStudents")
    public Collection<StudentResponse> findAllSucceededStudentsApi() {
        return studentService.findAllSucceeded();
    }

    @PutMapping("update/{id}")
    public String updateApi(@PathVariable UUID id, @RequestBody StudentUpdate studentUpdateRequest) {
        studentService.update(id, studentUpdateRequest);

        return "Successfully updated student with email: " + studentUpdateRequest.email();
    }

    @DeleteMapping("delete")
    public String deleteApi(@RequestParam UUID id) {
        final StudentResponse studentResponse = studentService.findById(id);

        studentService.deleteById(id);

        return "Successfully deleted student with email: " + studentResponse.email();
    }

    @DeleteMapping("deleteAll")
    public String deleteAllApi() {
        studentService.deleteAll();

        return "Successfully deleted all students";
    }
}

