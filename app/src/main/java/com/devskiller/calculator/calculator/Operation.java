package com.devskiller.calculator.calculator;

import java.math.BigInteger;

import com.annimon.stream.function.BinaryOperator;

public enum Operation {

    NONE((acc, arg) -> arg),
    ADD(BigInteger::add),
    SUBTRACT(BigInteger::subtract),
    MULTIPLY(BigInteger::multiply),
    DIVIDE(BigInteger::divide);

    private final BinaryOperator<BigInteger> operationHandler;

    Operation(BinaryOperator<BigInteger> operationHandler) {
        this.operationHandler = operationHandler;
    }

    public BigInteger perform(BigInteger acc, BigInteger argument) {
        return operationHandler.apply(acc, argument);
    }
}
