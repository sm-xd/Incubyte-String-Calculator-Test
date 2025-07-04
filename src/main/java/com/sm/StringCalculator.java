package com.sm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String numbers = stripDelimiterDeclaration(input);
        List<String> delimiters = extractDelimiters(input);

        String delimiterRegex = String.join("|", delimiters);
        String[] parts = numbers.split(delimiterRegex);

        List<Integer> numbersList = parseNumbers(parts);
        validateNoNegatives(numbersList);

        return numbersList.stream()
                .filter(n -> n <= 1000)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<String> extractDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();

        if (input.startsWith("//")) {
            String header = input.substring(2, input.indexOf('\n'));

            var matcher = Pattern.compile("\\[(.*?)]").matcher(header);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }

            if (delimiters.isEmpty()) {
                delimiters.add(Pattern.quote(header));
            }
        } else {
            delimiters.add(Pattern.quote(","));
            delimiters.add(Pattern.quote("\n"));
        }

        return delimiters;
    }

    private String stripDelimiterDeclaration(String input) {
        if (input.startsWith("//")) {
            return input.substring(input.indexOf('\n') + 1);
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
