package com.pioneers.rest.success.uitils;


import com.pioneers.rest.task.errors.exceptions.StudentException;

public final class StudentValidation {

    private StudentValidation() {
        throw new AssertionError("this is utility class");
    }

    public static void validateName(final String name) throws StudentException {
        if (name.isBlank() ||name.length() < 3 || name.length() > 20) {
            throw new StudentException("this is student is failed");
        }
    }

    public static void validateAge(final int age) throws StudentException {
        if (age < 18 || age > 25) {
            throw new StudentException("this is student is failed");
        }
    }

}
