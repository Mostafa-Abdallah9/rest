package com.pioneers.rest.exampleforme.controllers.utils.validators;

import com.pioneers.rest.exampleforme.controllers.models.dtos.requests.StudentRegister;
import com.pioneers.rest.exampleforme.controllers.models.entites.Student;

import java.util.*;

public class StudentValidation {

    public static List<String> validateStudentRegisterRequest
            (StudentRegister studentRegister) {
        List<String>errors = new ArrayList<>();

        if (isNullOrBlank(studentRegister.getFirstName())) {
             errors.add("first name is required");
        }

        if (isNullOrBlank(studentRegister.getLastName())) {
             errors.add("last name is required");
        }

        if (studentRegister.getAge() == 0 || (isAgeAligned(studentRegister.getAge()))) {
             errors.add("age is required");
        }

        if (isEmailInvalid(studentRegister.getEmail())) {
             errors.add("email is required");
        }

        if (isPasswordInvalid(studentRegister.getPassword())) {
             errors.add("password is required");
        }
        return errors;
    }

    private static boolean isPasswordInvalid(final String password) {
        return isNullOrBlank(password) ||
                (password.length() < 8 || password.length() > 32);
    }

    private static boolean isEmailInvalid(final String email) {
        return isNullOrBlank(email) || !email.contains("@");
    }

    private static boolean isAgeAligned(final int age) {
        return age < 18 || age > 23;
    }

    public static boolean isNullOrBlank(final String string) {
        return string == null || string.isBlank();
    }

    public static boolean isStudentPassed(final Student student) {
        return student.getScore()/student.getFinalScore() > 0.5f;
    }



}
