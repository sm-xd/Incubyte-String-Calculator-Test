package com.sm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("Returns 0 for empty string")
    void shouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    @DisplayName("Returns same number when only one number is provided")
    void shouldReturnSameNumberForSingleInput() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    @DisplayName("Returns sum of two comma-separated numbers")
    void shouldReturnSumOfTwoNumbers() {
        assertEquals(9, calculator.add("4,5"));
    }

    @Test
    @DisplayName("Handles multiple comma-separated numbers")
    void shouldHandleMultipleNumbers() {
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    @Test
    @DisplayName("Supports newlines between numbers")
    void shouldSupportNewlineBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    @DisplayName("Supports custom delimiter syntax //delimiter\\n")
    void shouldSupportCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    @DisplayName("Throws NegativeNumberException with list of negatives")
    void shouldThrowForNegativeNumbers() {
        NegativeNumberException ex = assertThrows(NegativeNumberException.class, () ->
                calculator.add("1,-2,-3")
        );
        assertEquals("negative numbers not allowed: -2, -3", ex.getMessage());
    }
}
