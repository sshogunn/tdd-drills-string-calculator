package com.epam.engx.drills.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Nurmakanov
 */
public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    public void shouldReturnZeroWhenPassedStringIsEmpty() {
        int expectedResult = 0;
        assertCalculateNumber("", expectedResult);
    }

    @Test
    public void shouldReturnNumberWhenDoesNotHaveAnyDelimiters() {
        int expectedResult = 7;
        assertCalculateNumber("7", expectedResult);
    }

    @Test
    public void shouldReturnNumberWhenDoesNotHaveAnyDelimiters2() {
        int expectedResult = 4;
        assertCalculateNumber("4", expectedResult);
    }

    @Test
    public void shouldCalculateTwoNumbersSeparatedByOneDelimiter() {
        int expectedResult = 8;
        assertCalculateNumber("5,3", expectedResult);
    }

    @Test
    public void shouldCalculateThreeNumbersSeparatedDelimiters() {
        int expectedResult = 12;
        assertCalculateNumber("5,3,4", expectedResult);
    }

    @Test
    public void shouldCalculateNumbersWhenDelimiterIsNewLine() {
        int expectedResult = 14;
        assertCalculateNumber("9\n5", expectedResult);
    }

    @Test
    public void shouldCalculateNumbersWhenDelimitersAreDifferent() {
        int expectedResult = 17;
        assertCalculateNumber("5\n5,7", expectedResult);
    }

    @Test
    public void shouldCalculateOneNumberWhenDelimiterAtTheBeginning() {
        int expectedResult = 7;
        assertCalculateNumber("\n7", expectedResult);
    }

    @Test
    public void shouldUseDelimiterPassedAtTheBeginningWhenItHasNewLineAfter() {
        int expectedResult = 17;
        assertCalculateNumber(";\n7;5;5", expectedResult);
    }

    private void assertCalculateNumber(String input, int expectedResult) {
        int result = calculator.calculate(input);
        assertThat(result, is(expectedResult));
    }
}
