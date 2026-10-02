package com.pioneers.rest.exampleforme.controllers.models.dtos.responses;

import java.util.Objects;

public class StudentResponse {
    private final String fullName;
    private final int age;

    public StudentResponse(String fulltName, int age) {
        this.fullName = fulltName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return age == that.age && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age);
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
