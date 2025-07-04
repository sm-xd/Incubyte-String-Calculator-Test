package com.sm;

import java.util.List;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(List<Integer> negatives) {
        super("negative numbers not allowed: " +
                String.join(", ", negatives.stream()
                        .map(String::valueOf)
                        .toArray(String[]::new)));
    }
}
