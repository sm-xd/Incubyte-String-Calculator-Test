package com.sm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void shouldSupportNewlineBetweenNumbers() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
    }

    @Test
    void shouldSupportCustomDelimiter() {
        assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }

    @Test
    void shouldThrowForNegativeNumbers() {
        NegativeNumberException ex = assertThrows(NegativeNumberException.class, () -> {
            new StringCalculator().add("1,-2,-3");
        });

        assertEquals("negative numbers not allowed: -2, -3", ex.getMessage());
    }


}
