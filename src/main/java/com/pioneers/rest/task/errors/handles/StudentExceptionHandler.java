//package com.pioneers.rest.task.errors.handles;
//
//import com.pioneers.rest.task.errors.exceptions.StudentException;
//import com.pioneers.rest.task.errors.models.ErrorResponse;
//import com.pioneers.rest.task.errors.models.GenericResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//public class StudentExceptionHandler {
//
//    @ResponseBody
//    @ExceptionHandler(exception = StudentException.class)
//    public GenericResponse<ErrorResponse> handleStudentException(final StudentException e) {
//        return new GenericResponse<>(
//                StudentException.CODE,
//                e.getCurrentTimestamp(),
//                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
//        );
//    }
//}