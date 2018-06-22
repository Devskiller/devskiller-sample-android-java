package verify_pack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import com.devskiller.calculator.calculator.Calculator;
import com.devskiller.calculator.calculator.Operation;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldSetValueOnEmptyCalculator() {
        //when
        BigInteger result = calculator.evaluate(BigInteger.TEN);

        //then
        assertThat(result).isEqualTo(BigInteger.TEN);
    }

    @Test
    public void shouldEvaluateAdding() {
        //given
        calculator.evaluate(BigInteger.ONE);
        calculator.setOperation(Operation.ADD);

        //when
        BigInteger result = calculator.evaluate(BigInteger.ONE);

        //then
        assertThat(result).isEqualTo(new BigInteger("2"));
    }

    @Test
    public void shouldEvaluateSubtraction() {
        //given
        calculator.evaluate(BigInteger.TEN);
        calculator.setOperation(Operation.SUBTRACT);

        //when
        BigInteger result = calculator.evaluate(BigInteger.ONE);

        //then
        assertThat(result).isEqualTo(new BigInteger("9"));
    }

    @Test
    public void shouldEvaluateMultiplication() {
        //given
        calculator.evaluate(BigInteger.TEN);
        calculator.setOperation(Operation.MULTIPLY);

        //when
        BigInteger result = calculator.evaluate(BigInteger.TEN);

        //then
        assertThat(result).isEqualTo(new BigInteger("100"));
    }

    @Test
    public void shouldEvaluateDivision() {
        //given
        calculator.evaluate(BigInteger.TEN);
        calculator.setOperation(Operation.DIVIDE);

        //when
        BigInteger result = calculator.evaluate(BigInteger.valueOf(5));

        //then
        assertThat(result).isEqualTo(new BigInteger("2"));
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowWhenDividedByZero() {
        //given
        calculator.evaluate(BigInteger.TEN);
        calculator.setOperation(Operation.DIVIDE);

        //when
        calculator.evaluate(BigInteger.ZERO);

        //then
        fail("Exception wasn't thrown! Should ever get here!");
    }

}