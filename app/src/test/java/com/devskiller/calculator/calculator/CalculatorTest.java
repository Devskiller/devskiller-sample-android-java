package com.devskiller.calculator.calculator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shouldSetValueOnEmptyCalculator() throws Exception {

        //when
        BigInteger result = calculator.evaluate(BigInteger.TEN);

        //then
        assertThat(result).isEqualTo(BigInteger.TEN);
    }

    @Test
    public void shouldEvaluateAdding() throws Exception {

        //given
        calculator.evaluate(BigInteger.ONE);
        calculator.setOperation(OPERATION.ADD);

        //when
        BigInteger result = calculator.evaluate(BigInteger.ONE);

        //then
        assertThat(result).isEqualTo(new BigInteger("2"));
    }

    @Test
    public void shouldEvaluateSubtraction() throws Exception {

        //given
        calculator.evaluate(BigInteger.TEN);
        calculator.setOperation(OPERATION.SUBTRACT);

        //when
        BigInteger result = calculator.evaluate(BigInteger.ONE);

        //then
        assertThat(result).isEqualTo(new BigInteger("9"));
    }

    @Test
    public void shouldEvaluateMultiplication() throws Exception {

        //given
        calculator.evaluate(BigInteger.TEN);
        calculator.setOperation(OPERATION.MULTIPLY);

        //when
        BigInteger result = calculator.evaluate(BigInteger.TEN);

        //then
        assertThat(result).isEqualTo(new BigInteger("100"));
    }
}