package com.devskiller.calculator.calculator;

import java.math.BigInteger;

public class Calculator {
    private Operation operation = Operation.NONE;
    private BigInteger accumulator = BigInteger.ZERO;

    public BigInteger evaluate(BigInteger value) {
        return accumulator = operation.perform(accumulator, value);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void clear() {
        operation = Operation.NONE;
        accumulator = BigInteger.ZERO;
    }
}
