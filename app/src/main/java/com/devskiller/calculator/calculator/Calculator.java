package com.devskiller.calculator.calculator;

import java.math.BigInteger;

public class Calculator {

    private OPERATION operation = OPERATION.NONE;
    private BigInteger accumulator = BigInteger.ZERO;

    public BigInteger evaluate(BigInteger value) {
        switch (operation) {
            case NONE:
                accumulator = value;
                break;
            case ADD:
                accumulator = accumulator.add(value);
                break;
            case SUBTRACT:
                accumulator = accumulator.subtract(value);
                break;
            case MULTIPLY:
                accumulator = accumulator.multiply(value);
                break;
            case DIVIDE:
                accumulator = accumulator.divide(value);
                break;
            default:
                throw new UnsupportedOperationException("Operation " + operation + " is not supported");
        }
        return accumulator;
    }

    public void setOperation(OPERATION operation) {
        this.operation = operation;
    }

}
