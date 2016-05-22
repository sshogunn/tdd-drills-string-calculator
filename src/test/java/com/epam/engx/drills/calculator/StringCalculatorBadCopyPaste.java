package com.epam.engx.drills.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Nurmakanov
 */
public class StringCalculatorBadCopyPaste {

    @Test
    public void shouldReturnZeroWhenPassedStringIsEmpty() {
        int expectedResult = 0;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldReturnNumberWhenDoesNotHaveAnyDelimiters() {
        int expectedResult = 7;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("7");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldReturnNumberWhenDoesNotHaveAnyDelimiters2() {
        int expectedResult = 4;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("4");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldCalculateTwoNumbersSeparatedByOneDelimiter() {
        int expectedResult = 8;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("5,3");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldCalculateThreeNumbersSeparatedDelimiters() {
        int expectedResult = 12;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("5,3,4");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldCalculateNumbersWhenDelimiterIsNewLine() {
        int expectedResult = 14;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("9\n5");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldCalculateNumbersWhenDelimitersAreDifferent() {
        int expectedResult = 17;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("5\n5,7");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldCalculateOneNumberWhenDelimiterAtTheBeginning() {
        int expectedResult = 7;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("\n7");
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldUseDelimiterPassedAtTheBeginningWhenItHasNewLineAfter() {
        int expectedResult = 17;
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(";\n7;5;5");
        assertThat(result, is(expectedResult));
    }
}
