package com.sm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String delimiter = getDelimiter(input);
        input = stripDelimiterDeclaration(input);

        String[] parts = input.split(delimiter);
        List<Integer> numbers = parseNumbers(parts);
        validateNoNegatives(numbers);

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private String getDelimiter(String input) {
        if (input.startsWith("//")) {
            String delimiterDeclaration = input.split("\n", 2)[0].substring(2);
            return Pattern.quote(delimiterDeclaration);
        }
        return ",|\n";
    }

    private String stripDelimiterDeclaration(String input) {
        if (input.startsWith("//")) {
            return input.split("\n", 2)[1];
        }
        return input;
    }

    private List<Integer> parseNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNoNegatives(List<Integer> numbers) {
        List<Integer> negatives = numbers.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            throw new NegativeNumberException(negatives);
        }
    }

}
