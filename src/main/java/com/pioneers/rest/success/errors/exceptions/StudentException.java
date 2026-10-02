//package com.pioneers.rest.success.errors.exceptions;
//
//import com.pioneers.rest.task.utils.times.TimeHelper;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//
//import java.sql.Timestamp;
//import java.util.Map;
//
//@Getter
//@EqualsAndHashCode(callSuper = false)
//public class StudentException extends RuntimeException {
//
//    private final Map<String, String> errors;
//
//    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();
//
//    public static final int CODE = 9001;
//    public StudentException(Map<String, String> errors) {
//        this.errors = errors;    }
//}
