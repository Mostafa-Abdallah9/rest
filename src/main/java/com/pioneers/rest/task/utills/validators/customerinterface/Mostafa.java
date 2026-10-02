package com.pioneers.rest.task.utills.validators.customerinterface;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {MostafaAn.class})
@Target( ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mostafa {
    int min() default 18;

    int max() default 25;
    String message() default "not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
