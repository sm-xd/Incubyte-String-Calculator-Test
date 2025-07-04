package com.sm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            String[] headerSplit = input.split("\n", 2);
            String delimiterPart = headerSplit[0].substring(2);
            delimiter = Pattern.quote(delimiterPart);
            input = headerSplit[1];
        }

        String[] parts = input.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int num = Integer.parseInt(part.trim());

            if (num < 0) {
                negatives.add(num);
            } else {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new NegativeNumberException(negatives);
        }

        return sum;
    }

}
