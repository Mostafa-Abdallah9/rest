package com.pioneers.rest.task.services;



import com.pioneers.rest.task.errors.exceptions.*;
import com.pioneers.rest.task.models.dtos.requests.StudentLogin;
import com.pioneers.rest.task.models.dtos.requests.StudentRegister;
import com.pioneers.rest.task.models.dtos.responses.GenericResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;

import java.util.List;
public interface AuthStudentService {

    void signup( final StudentRegister studentRegisterRequest) throws RegisterException, ValidationException;

    void login( final StudentLogin studentLoginRequest) throws LoginException, CredentialsException;

    void logout(@Email(message = "{validation.email.pattern}") String email) throws LogoutException;

    GenericResponse<?> saveAll(final List<StudentRegister> studentRegisterRequests)
            throws RegisterException, ValidationException;
}
