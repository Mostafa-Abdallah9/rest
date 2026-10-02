package com.pioneers.rest.task.utills.validators.customerinterface;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MostafaAn implements ConstraintValidator<Mostafa,String> {

    private int min;
    private int max;

    @Override
    public void initialize(Mostafa constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return s.length() >= min  && s.length() <= max ;

    }

}

