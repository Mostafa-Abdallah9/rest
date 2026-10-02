package com.pioneers.rest.exampleforme.controllers.models.dtos.requests;

import java.util.Objects;

public class StudentLogin {
    private final String password;
    private final String email;

    public StudentLogin(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentLogin that = (StudentLogin) o;
        return Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, email);
    }

    @Override
    public String toString() {
        return "StudentLogin{" +
                "password=**********'" + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
