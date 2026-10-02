package com.pioneers.rest.task.utils.mappers;


import com.pioneers.rest.task.models.dtos.responses.StudentResponse;
import com.pioneers.rest.task.models.entities.Student;

public final class StudentMapper {
    private StudentMapper() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static StudentResponse toStudentResponse(final Student student) {
        return new StudentResponse(student.getFullName(), student.getAge(), student.getEmail());
    }
}
