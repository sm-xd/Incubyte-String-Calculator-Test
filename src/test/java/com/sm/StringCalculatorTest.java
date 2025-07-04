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

}
