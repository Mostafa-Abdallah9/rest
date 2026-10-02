//package com.pioneers.rest.exampleforme.controllers.graph;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@ControllerAdvice
//public class MostafaHandles {
//@ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(exception = MostafaException.class)
//    public MostafaResponse<?> handleMostafaException(final MostafaException e) {
//        return new MostafaResponse<>(
//               MostafaException.CODE,
//                MostafaException.message,
//                e.getDescription(),
//                e.getTimestamp(),
//                Optional.empty()
//
//        );
//    }
//}
