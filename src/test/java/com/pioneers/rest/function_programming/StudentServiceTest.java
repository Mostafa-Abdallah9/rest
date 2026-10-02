package com.pioneers.rest.function_programming;

import com.pioneers.rest.function_programming.nn.StudentRegister;
import com.pioneers.rest.function_programming.nn.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(Extension.class)
 class StudentServiceTest {

//    @InjectMocks
    private static StudentService studentService;

    @BeforeAll
   static void beforeAll(){
        studentService = new StudentService();
    }

    @Test
     void testApply_whenNameAndAgeAreCorrect_ThenNotThrowException() {
        //Arrange
        final StudentRegister studentRegister = new StudentRegister("elsayed",24);

        //Action

        //Assert
         assertDoesNotThrow(()->
                 studentService.apply(studentRegister,()->System.out.println("Student registered successfully")));
     }

    @Test
    void testApply_whenNameAndAgeAreNotCorrect_ThenThrowException() {
        //Arrange
        final StudentRegister studentRegister = new StudentRegister("el", 26);

        //Action

        //Assert
        assertThrows(RuntimeException.class, () ->
                studentService.apply(
                        studentRegister,
                        () -> System.out.println("Student registered successfully")
                )
        );
    }
}
