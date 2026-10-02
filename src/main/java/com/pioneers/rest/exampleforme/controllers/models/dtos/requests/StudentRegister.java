package com.pioneers.rest.exampleforme.controllers.models.dtos.requests;

import java.util.Objects;

/**
 * Create a system for a university including signup, login, Logout APIs.
 * Create API to Register multiple students.
 * Create some APIs delete, update students and find the student.
 * Create some APIs to filter students who passed the final exam, and the student ranked the first among his mates.
 */
public class StudentRegister {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String password;

    public StudentRegister(String firstName, String lastName, int age, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentRegister that = (StudentRegister) o;
        return age == that.age
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(email, that.email)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, email, password);
    }

    @Override
    public String toString() {
        return "StudentRegister{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='***************"  + '\'' +
                '}';
    }
}