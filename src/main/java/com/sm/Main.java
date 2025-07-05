package com.sm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();

        System.out.println("Welcome to the String Calculator!");
        System.out.println("Enter a string of numbers (or type 'exit' to quit):");

        while (true) {
            System.out.print("\nInput: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting.");
                break;
            }

            try {
                input = input.replace("\\n", "\n");

                int result = calculator.add(input);
                System.out.println("Result: " + result);
            } catch (NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
