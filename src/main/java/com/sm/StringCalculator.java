package com.sm;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        String[] parts = numbers.split(",");
        return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }

}
