package com.sm;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            String[] header = numbers.split("\n", 2);
            delimiter = Pattern.quote(header[0].substring(2));
            numbers = header[1];
        }

        String[] parts = numbers.split(delimiter);
        return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }

}
