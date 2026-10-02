package com.pioneers.rest.task.models.dtos.requests;

import com.pioneers.rest.task.utils.validators.ValidationRules;
import com.pioneers.rest.task.utils.validators.ValidationRulesService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record StudentLogin(
//        @Email(message = "Email must be valid")
        String email,
//        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
//                message = "Password doesn't meed the criteria")
        String password) {

    public void validate() throws ValidationRulesService.ValidationException {
        ValidationRulesService.validate(ValidationRules.EMAIL, email);
        ValidationRulesService.validate(ValidationRules.PASSWORD, password);
    }

    @Override
    public String toString() {
        return "StudentLogin{" +
                "email='" + email + '\'' +
                ", password='**********'" +
                '}';
    }
}
