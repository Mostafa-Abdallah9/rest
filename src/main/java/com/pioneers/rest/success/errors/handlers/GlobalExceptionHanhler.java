//package com.pioneers.rest.success.errors.handlers;
//
//import com.pioneers.rest.function_programming.nn.ErrorResponse;
//import com.pioneers.rest.function_programming.nn.GenericResponse;
//import com.pioneers.rest.function_programming.nn.ValidationExceptionHandler;
//import com.pioneers.rest.function_programming.nn.ValidationRulesService;
//import com.pioneers.rest.task.errors.exceptions.StudentException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.List;
//
//import static com.pioneers.rest.task.utils.times.TimeHelper.currentTimestamp;
//
//@RestControllerAdvice
//public class GlobalExceptionHanhler {
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(StudentException.class)
//    public GenericResponse<List<ErrorResponse>> handleValidationException(
//            final StudentException e) {
//
//        final List<ErrorResponse> errorResponseList = e.getErrors()
//                .entrySet()
//                .stream()
//                .map(ValidationExceptionHandler::toErrorResponse)
//                .toList();
//
//        return new GenericResponse<>(
//                ValidationRulesService.ValidationException.CODE, currentTimestamp(), errorResponseList);
//    }
//}
