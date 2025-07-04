package com.sm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    void shouldReturnSameNumberForSingleInput() {
        assertEquals(5, new StringCalculator().add("5"));
    }

    @Test
    void shouldReturnSumOfTwoNumbers() {
        assertEquals(9, new StringCalculator().add("4,5"));
    }

    @Test
    void shouldHandleMultipleNumbers() {
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
    }


}
