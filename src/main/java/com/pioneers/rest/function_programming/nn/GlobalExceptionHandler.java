package com.pioneers.rest.function_programming.nn;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ElementKind;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.pioneers.rest.task.utils.times.TimeHelper.currentTimestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationRulesService.ValidationException.class)
    public GenericResponse<List<ErrorResponse>> handleValidationException(
            final ValidationRulesService.ValidationException e) {

        final List<ErrorResponse> errorResponseList = e.getErrors()
                .entrySet()
                .stream()
                .map(ValidationExceptionHandler::toErrorResponse)
                .toList();

        return new GenericResponse<>(
                ValidationRulesService.ValidationException.CODE, currentTimestamp(), errorResponseList);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public GenericResponse<List<ErrorResponse>> handleConstraintViolationException(final ConstraintViolationException e) {
        final List<ErrorResponse> errorResponseList = e.getConstraintViolations().stream()
                .toList()
                .stream()
                .map(this::from)
                .toList();
        return new GenericResponse<>(9100, currentTimestamp(), errorResponseList);
    }

    private ErrorResponse from(final ConstraintViolation<?> constraintViolation) {
        final AtomicReference<String> fieldName = new AtomicReference<>();
        constraintViolation.getPropertyPath()
                .forEach(node -> {
                    if (isNodeKindParameter(node.getKind())) {
                        fieldName.set(node.getName());
                    }
                });
        return new ErrorResponse(fieldName.get(), constraintViolation.getMessage());
    }

    private boolean isNodeKindParameter(final ElementKind elementKind) {
        return ElementKind.PARAMETER.equals(elementKind);
    }

    private ErrorResponse from(final FieldError fieldError) {
        return new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
    }

}
