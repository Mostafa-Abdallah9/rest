package com.pioneers.rest.task.errors.handles;

import com.pioneers.rest.task.errors.exceptions.CredentialsException;
import com.pioneers.rest.task.errors.exceptions.LoginException;
import com.pioneers.rest.task.errors.exceptions.LogoutException;
import com.pioneers.rest.task.errors.exceptions.RegisterException;
import com.pioneers.rest.task.errors.models.ErrorResponse;
import com.pioneers.rest.task.errors.models.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthStudentHandler {

    @ExceptionHandler(RegisterException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<ErrorResponse> handleRegisterException(
            final RegisterException e) {

        return new GenericResponse<>(
                RegisterException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(
                        RegisterException.MESSAGE,
                        e.getDescription()
                )
        );
    }

    @ExceptionHandler(LogoutException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<ErrorResponse> handleLogoutException(
            final LogoutException e) {

        return new GenericResponse<>(
                LogoutException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(
                        LogoutException.MESSAGE,
                        e.getDescription()
                )
        );
    }

    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<ErrorResponse> handleLoginException(
            final LoginException e) {

        return new GenericResponse<>(
                LoginException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(
                        LoginException.MESSAGE,
                        e.getDescription()
                )
        );
    }

    @ExceptionHandler(CredentialsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<ErrorResponse> handleCredentialsException(
            final CredentialsException e) {

        return new GenericResponse<>(
                CredentialsException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(
                        CredentialsException.MESSAGE,
                        e.getDescription()
                )
        );
    }
}