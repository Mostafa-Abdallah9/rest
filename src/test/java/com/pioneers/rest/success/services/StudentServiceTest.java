package com.pioneers.rest.success.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {
    private static StudentService studentService;

    @BeforeAll
    static void beforeAll() {
        studentService = new StudentService();
    }

    @Test
    void testVlidate_whenStudentValidationIsSuccess_thenReturnSuccessMessage(){

        //Arrange
        final StudentSuccess studentSuccess = new StudentSuccess();
        final StudentFailure studentFailure = new StudentFailure();

        final String name = "mostafa";
        final int age = 20;

        //Action
       final String result =
               studentService.validate(
                       name,
                       age,
                       studentSuccess,
                       studentFailure
               );

       //Assertion
        Assertions.assertEquals("SUCCESS: Student registered successfully",result);

    }

    @Test
    void testVlidate_whenStudentValidationIsFailure_thenReturnFailureMessage(){

        //Arrange
        final StudentSuccess studentSuccess = new StudentSuccess();
        final StudentFailure studentFailure = new StudentFailure();

        final String name = "mo";
        final int age = 20;

        //Action
        final String result =
                studentService.validate(
                        name,
                        age,
                        studentSuccess,
                        studentFailure
                );

        //Assertion
        Assertions.assertEquals("FAILED: this is student is failed",result);

    }

}
