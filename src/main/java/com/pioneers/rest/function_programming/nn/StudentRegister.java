package com.pioneers.rest.function_programming.nn;

import java.util.LinkedHashMap;
import java.util.Map;

public record StudentRegister(

//        @NotBlank(message = "this is student is failed")
//        @Size(min = 3,max = 20,message = "this is student is failed")
        String name,
//        @Min(value = 18,message = "this is student is failed")
//        @Max(value = 25,message = "this is student is failed")
        int age

) {

        public void validate() {
                final Map<String, String> errors = new LinkedHashMap<>();

                try {
                        ValidationRulesService.validate(ValidationRules.NAME, name);
                } catch (final ValidationRulesService.RuleException e) {
                        errors.putIfAbsent(e.getMessage(), e.getDescription());
                }
                try {
                        ValidationRulesService.validate(ValidationRules.AGE, String.valueOf(age));
                } catch (final ValidationRulesService.RuleException e) {
                        errors.putIfAbsent(e.getMessage(), e.getDescription());
                }
                if (!errors.isEmpty()) {
                        throw new ValidationRulesService.ValidationException(errors);
                }
        }
}
