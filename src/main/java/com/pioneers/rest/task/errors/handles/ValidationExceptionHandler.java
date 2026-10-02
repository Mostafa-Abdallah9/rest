//package com.pioneers.rest.task.errors.handles;
//
//import com.pioneers.rest.task.errors.models.ErrorResponse;
//import com.pioneers.rest.task.errors.models.GenericResponse;
//import com.pioneers.rest.task.utils.validators.ValidationRulesService;
//import jakarta.validation.ConstraintViolationException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.List;
//import java.util.Map;
//
//import static com.pioneers.rest.task.utils.times.TimeHelper.currentTimestamp;
//
//
//@Slf4j
//@RestControllerAdvice
//@RequiredArgsConstructor
//public class ValidationExceptionHandler {
//
//    private final MessageSource messageSource;
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(exception = ValidationRulesService.ValidationException.class)
//    public GenericResponse<List<ErrorResponse>> handleValidationException(
//            final ValidationRulesService.ValidationException e) {
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
//
//    private static ErrorResponse toErrorResponse(final Map.Entry<String, String> entry) {
//        return new ErrorResponse(entry.getKey(), entry.getValue());
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
//    public GenericResponse<List<ErrorResponse>> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
//        final List<ErrorResponse> errorResponseList = e.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(this::from)
//                .toList();
//
//        return new GenericResponse<>(9000, currentTimestamp(), errorResponseList);
//    }
//
//    private ErrorResponse from(final FieldError fieldError) {
//        String resolvedMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
//        return new ErrorResponse(fieldError.getField(), resolvedMessage);
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(exception = ConstraintViolationException.class)
//    public void handleConstraintViolationException(final ConstraintViolationException e) {
//        System.out.println(e.getConstraintViolations().stream()
//                .toList()
//                .get(0)
//                .getMessage());
//        System.out.println(((MaterializedNode) e.getConstraintViolations().stream()
//                .toList()
//                .get(0)
//                .getPropertyPath())
//                .getName()
//        );
//    }
//}