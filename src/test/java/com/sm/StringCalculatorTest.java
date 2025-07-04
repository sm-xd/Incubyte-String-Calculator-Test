package com.sm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }


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

    @Test
    @DisplayName("Ignores numbers greater than 1000")
    void shouldIgnoreNumbersGreaterThan1000() {
        assertEquals(2, calculator.add("2,1001"));
        assertEquals(1002, calculator.add("2,1000"));
    }

    @Test
    @DisplayName("Supports delimiter of any length")
    void shouldSupportMultiCharacterDelimiter() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    @DisplayName("Supports multiple custom single-character delimiters")
    void shouldSupportMultipleSingleCharDelimiters() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }


    @Test
    @DisplayName("Handles multiple-digit numbers")
    void shouldHandleMultipleDigitNumbers() {
        assertEquals(123, calculator.add("100,23"));
    }

    @Test
    @DisplayName("Trims whitespace between numbers")
    void shouldTrimWhitespaceAroundNumbers() {
        assertEquals(6, calculator.add(" 1 , 2 , 3 "));
    }

    @Test
    @DisplayName("Supports custom delimiter with special characters")
    void shouldSupportSpecialCharacterDelimiter() {
        assertEquals(6, calculator.add("//.\n1.2.3"));
    }

    @Test
    @DisplayName("Ignores empty values between delimiters")
    void shouldIgnoreEmptyValues() {
        assertEquals(6, calculator.add("1,,2,3"));
    }

    @Test
    @DisplayName("Throws exception when negative number is at start or end")
    void shouldThrowForNegativeAtEdges() {
        NegativeNumberException ex = assertThrows(NegativeNumberException.class, () ->
                calculator.add("-1,2,3,-4")
        );
        assertEquals("negative numbers not allowed: -1, -4", ex.getMessage());
    }

    @Test
    @DisplayName("Returns 0 for custom delimiter declaration with no numbers")
    void shouldHandleOnlyCustomDelimiterDeclaration() {
        assertEquals(0, calculator.add("//;\n"));
    }

    @Test
    @DisplayName("Throws exception with one negative number")
    void shouldThrowForSingleNegative() {
        NegativeNumberException ex = assertThrows(NegativeNumberException.class, () ->
                calculator.add("7,-9")
        );
        assertEquals("negative numbers not allowed: -9", ex.getMessage());
    }

}
