package com.pioneers.rest.task.models.dtos.requests;

import com.pioneers.rest.task.utills.validators.customerinterface.ValidationMessages;
import com.pioneers.rest.task.utils.validators.ValidationRules;
import com.pioneers.rest.task.utils.validators.ValidationRulesService;
import jakarta.validation.constraints.NotBlank;

import java.util.LinkedHashMap;
import java.util.Map;

public record StudentRegister(
        @NotBlank(message = ValidationMessages.FIRST_NAME_BLANK)
//        @Size(min = 2, max = 15, message = ValidationMessages.FIRST_NAME_SIZE)
//        @Mostafa(min = 5,max = 15)
        String firstName,

//        @NotBlank(message = ValidationMessages.SECOND_NAME_BLANK)
//        @Size(min = 2, max = 15, message = ValidationMessages.SECOND_NAME_SIZE)
        String secondName,

//        @Age(min = 15,max = 23)
        int age,

//        @Email(message = ValidationMessages.EMAIL_PATTERN)
        String email,
//        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
//                message = ValidationMessages.PASSWORD_PATTERN)
        String password)

        {

    public void validate() {
        final Map<String, String> errors = new LinkedHashMap<>();
        try {
            ValidationRulesService.validate(ValidationRules.FIRST_NAME, firstName);
        } catch (final ValidationRulesService.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRulesService.validate(ValidationRules.SECOND_NAME, secondName);
        } catch (final ValidationRulesService.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRulesService.validate(ValidationRules.AGE, String.valueOf(age));
        } catch (ValidationRulesService.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRulesService.validate(ValidationRules.EMAIL, email);
        } catch (ValidationRulesService.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRulesService.validate(ValidationRules.PASSWORD, password);
        } catch (ValidationRulesService.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }

        if (!errors.isEmpty()) {
            throw new ValidationRulesService.ValidationException(errors);
        }
    }
    }


