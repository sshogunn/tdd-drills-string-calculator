package com.epam.engx.drills.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Nurmakanov
 */
public class StringCalculatorBadManyAsserts {
    private StringCalculator calculator = new StringCalculator();

    @Test
    public void checkingCalculation() {
        int result1 = calculator.calculate("");
        assertThat(result1, is(0));

        int result2 = calculator.calculate("7");
        assertThat(result2, is(7));

        int result3 = calculator.calculate("5,3");
        assertThat(result3, is(7));
    }
}
