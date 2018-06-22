package com.devskiller.calculator.calculator;

import java.math.BigInteger;

public class Display {
    private BigInteger value = BigInteger.ZERO;
    private boolean completed = false;

    public void insertDigit(int digit) {
        if (completed) {
            this.value = BigInteger.ZERO;
            completed = false;
        }
        this.value = value.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));
    }

    public void removeDigit() {
        value = value.divide(BigInteger.TEN);
    }

    public void clear() {
        value = BigInteger.ZERO;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
        completed = true;
    }

    public String getLine() {
        return value.toString();
    }
}
