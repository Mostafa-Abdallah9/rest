package com.pioneers.rest.task.utills.validators.customerinterface;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age,Integer> {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 25;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }

        return value >= MIN_AGE && value <= MAX_AGE;

    }

//   private int minAge;
//    private int maxAge;
//
//    @Override
//    public void initialize(Age constraintAnnotation) {
//        this.minAge = constraintAnnotation.min();
//        this.maxAge = constraintAnnotation.max();
//    }
//
//    @Override
//    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
//        if (value == null) {
//            return false;
//        }
//
//        return value >= minAge && value <= maxAge;
//
//    }
}

