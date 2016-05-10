package com.epam.engx.drills.calculator;

/**
 * @author Nurmakanov
 */
class StringCalculator {
    private static final String DELIMITERS = ",|\n";

    int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.length() > 1){
            char secondChar = input.charAt(1);
            char firstChar = input.charAt(0);
            boolean hasDefaultDelim = secondChar == '\n' && !Character.isDigit(firstChar);
            if (hasDefaultDelim) {
                String delimiter = String.valueOf(firstChar);
                String withoutDelimiter = input.substring(2);
                return sum(delimiter, withoutDelimiter);
            } else {
                return sum(DELIMITERS, input);
            }
        }
        return Integer.valueOf(input);
    }

    private int sum(String delimiter, String numbersInput) {
        String[] numbers = numbersInput.split(delimiter);
        if (numbers.length > 1) {
            return sum(numbers);
        }
        return -1;
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Integer.valueOf(number);
            }
        }
        return sum;
    }
}
