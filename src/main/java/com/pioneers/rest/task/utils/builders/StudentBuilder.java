package com.pioneers.rest.task.utils.builders;


import com.pioneers.rest.task.models.entities.Student;

import static com.pioneers.rest.task.utils.IdHelper.randomUuidV4;

public final class StudentBuilder {

    private StudentBuilder() {
        throw new AssertionError("Utility Class");
    }

    public static Student buildRegisteredStudent(
            final int age,
            final String email,
            final String fullName,
            final String hashedPassword
    ) {
        return Student.builder()
                .id(randomUuidV4())
                .fullName(fullName)
                .age(age)
                .email(email)
                .password(hashedPassword)
                .isLoggedIn(false)
                .score(0.0F)
                .finalScore(0.0F)
                .build(); }
}
