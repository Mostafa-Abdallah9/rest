package com.pioneers.rest.success.controllers;

import com.pioneers.rest.success.models.dtos.requests.StudentRegister;
import com.pioneers.rest.success.services.StudentFailure;
import com.pioneers.rest.success.services.StudentService;
import com.pioneers.rest.success.services.StudentSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("save")
    public String showStatus(@RequestBody StudentRegister studentRegister) {
      return studentService.validate(
              studentRegister.name(),
              studentRegister.age(),
              new StudentSuccess(),
              new StudentFailure());
    }
}
