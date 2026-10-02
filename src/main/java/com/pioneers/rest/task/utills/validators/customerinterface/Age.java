package com.pioneers.rest.task.utills.validators.customerinterface;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AgeValidator.class})
public @interface Age {

    int min() default 18;

    int max() default 25;

    String message() default "{validation.age.custom-annotation}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
