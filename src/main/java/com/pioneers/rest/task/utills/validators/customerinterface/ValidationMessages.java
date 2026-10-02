package com.pioneers.rest.task.utills.validators.customerinterface;

public final class ValidationMessages {

    private ValidationMessages() {

    }

    public static final String FIRST_NAME_BLANK = "First Name must not be null or blank";
    public static final String FIRST_NAME_SIZE = "First Name must be between 2 and 15";
    public static final String SECOND_NAME_BLANK = "Second Name must not be null or blank";
    public static final String SECOND_NAME_SIZE = "Second Name must be between 2 and 15";

    public static final String AGE_MIN = "Age must be at least 18 years old";
    public static final String AGE_MAX = "Age must be at most 25 years old";
    public static final String AGE_CUSTOM_ANNOTATION = "Age is incompatible";

    public static final String EMAIL_PATTERN = "Email must be valid";
    public static final String PASSWORD_PATTERN = "Password doesn't meet the criteria";

}
