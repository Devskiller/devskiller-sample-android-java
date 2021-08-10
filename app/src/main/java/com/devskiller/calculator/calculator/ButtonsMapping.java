package com.devskiller.calculator.calculator;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;

@SuppressLint("UseSparseArrays")
public final class ButtonsMapping {

    static final Map<Integer, Operation> MATH_OPERATIONS = new HashMap<>();
    static final Map<Integer, Integer> DIGITS = new HashMap<>();

    static {
        MATH_OPERATIONS.put(R.id.btnEqual, Operation.NONE);
        MATH_OPERATIONS.put(R.id.btnAdd, Operation.ADD);
        MATH_OPERATIONS.put(R.id.btnSubstract, Operation.SUBTRACT);
        MATH_OPERATIONS.put(R.id.btnMultiply, Operation.MULTIPLY);
        MATH_OPERATIONS.put(R.id.btnDivide, Operation.DIVIDE);

        DIGITS.put(R.id.btn0, 0);
        DIGITS.put(R.id.btn1, 1);
        DIGITS.put(R.id.btn2, 2);
        DIGITS.put(R.id.btn3, 3);
        DIGITS.put(R.id.btn4, 4);
        DIGITS.put(R.id.btn5, 5);
        DIGITS.put(R.id.btn6, 6);
        DIGITS.put(R.id.btn7, 7);
        DIGITS.put(R.id.btn8, 8);
        DIGITS.put(R.id.btn9, 9);
    }

    private ButtonsMapping() {
    }
}
