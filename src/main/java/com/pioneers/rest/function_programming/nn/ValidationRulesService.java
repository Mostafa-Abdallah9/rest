package com.pioneers.rest.function_programming.nn;

import com.pioneers.rest.task.utils.times.TimeHelper;
import com.pioneers.rest.task.utils.validators.ValidatorService;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import static com.pioneers.rest.task.utils.StringUtils.isNullOrBlank;

public final class ValidationRulesService {
    private static final Map<ValidationRules,ValidatorService<String>> RULES = new EnumMap(ValidationRules.class);

    static {
        RULES.putIfAbsent(ValidationRules.NAME, ValidationRulesService::validateName);
        RULES.putIfAbsent(ValidationRules.AGE, ValidationRulesService::validateAge);
    }

    private ValidationRulesService() {
        throw new AssertionError("Utility class");
    }

    public static void validate(final ValidationRules rule, final String ruleValue) throws RuleException {

        if (isNullOrBlank(ruleValue)) {
            throw new RuleException(rule.name(), "Rule is null or Blank");
        }

        final ValidatorService<String> validatorService = findRule(rule)
                .orElseThrow(() -> new RuleException(rule.name(), "Rule doesn't exist in our system"));

        validatorService.validate(ruleValue);

    }

    private static Optional<ValidatorService<String>> findRule(final ValidationRules rule) {
        return Optional.ofNullable(RULES.get(rule));
    }

    private static void validateName(final String name) throws RuleException {
        if (name.length() < 3 || name.length() > 25) {
            throw new RuleException("name", "Name must be between 3 and 25");
        }
    }

    private static void validateAge(final String age) throws RuleException {
        final int intAge = Integer.parseInt(age);
        if (intAge < 18 || intAge > 25) {
            throw new RuleException("age", "Age is incompatible");
        }
    }

    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class RuleException extends RuntimeException {

        private final String message;
        private final String description;

        public RuleException(final String message, final String description) {
            super(description);

            this.message = message;
            this.description = description;
        }
    }

    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class ValidationException extends RuntimeException {

        private final Map<String, String> errors;

        private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

        public static final int CODE = 9001;

        public ValidationException(Map<String, String> errors) {
            this.errors = errors;
        }
    }
}

