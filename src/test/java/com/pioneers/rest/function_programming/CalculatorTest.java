package com.pioneers.rest.function_programming;

import com.pioneers.rest.function_programming.ex.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
class CalculatorTest {

//@Test
//@DisplayName("1")
//@Disabled
//@RepeatedTest(2)
    @ParameterizedTest
//    @ValueSource(ints = {1,3})
    @CsvSource(value = {
            "1,1,2",
            "2,2,4",
            "3,3,6"
    })
    void testAdd(final int num1,final int num2,final int expected) {
        // Arrange
    log.info(",,,,,");
    Calculator calculator = new Calculator();
        //Action
        final int actual = calculator.sum(num1,num1);
        //Assert
    assertEquals(expected,actual);
    }

    @Test
    void testAdd1() {
        // Arrange
        Calculator calculator = new Calculator();

        //Action
        final int actual = calculator.sum(1,-4);
        //Assert
        assertEquals(-3,actual);
    }
}
