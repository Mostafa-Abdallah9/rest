package com.pioneers.rest.success.services;

import com.pioneers.rest.success.Any;
import com.pioneers.rest.success.uitils.StudentValidation;
import com.pioneers.rest.task.errors.exceptions.StudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentService {

    public String validate(final String name , final int age,final OnSuccess onSuccess, final OnFailure onFailure) {
        try {
            StudentValidation.validateName(name);
            StudentValidation.validateAge(age);
           return onSuccess.onSuccess("Student registered successfully");
        } catch (StudentException e){
            return onFailure.onFailure(e.getMessage());
        }
    }
}
