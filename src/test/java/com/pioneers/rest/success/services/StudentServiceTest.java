package com.pioneers.rest.success.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {
    private static StudentService studentService;
    private StudentSuccess studentSuccess;
    private StudentFailure studentFailure;

    @BeforeAll
    static void beforeAll() {
        studentService = new StudentService();
    }

    @BeforeEach
     void beforeEach() {
       studentSuccess = new StudentSuccess();
       studentFailure = new StudentFailure();
    }

    @Test
    void testVlidate_whenStudentValidationIsSuccess_thenReturnSuccessMessage(){

        //Arrange
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
