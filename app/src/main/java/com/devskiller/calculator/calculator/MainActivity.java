package com.devskiller.calculator.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private static final Map<Integer, OPERATION> MATH_OPERATIONS = new HashMap<>();
    private static final Map<Integer, Integer> DIGITS = new HashMap<>();

    static {
        MATH_OPERATIONS.put(R.id.btnEqual, OPERATION.NONE);
        MATH_OPERATIONS.put(R.id.btnAdd, OPERATION.ADD);
        MATH_OPERATIONS.put(R.id.btnSubstract, OPERATION.SUBTRACT);
        MATH_OPERATIONS.put(R.id.btnMultiply, OPERATION.MULTIPLY);
        MATH_OPERATIONS.put(R.id.btnDivide, OPERATION.DIVIDE);

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

    private TextView result;

    private Calculator calculator = new Calculator();
    private Display display = new Display();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        findViewById(R.id.ce).setOnClickListener(this);
        findViewById(R.id.backspace).setOnClickListener(this);
        for (int id : MATH_OPERATIONS.keySet()) {
            findViewById(id).setOnClickListener(this);
        }
        for (int id : DIGITS.keySet()) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Log.v(TAG, "Onclick=" + view.getId());

        if (MATH_OPERATIONS.containsKey(view.getId())) {
            display.setValue(calculator.evaluate(display.getValue()));
            calculator.setOperation(selectedOperation(view));
        } else if (DIGITS.containsKey(view.getId())) {
            display.insertDigit(selectedDigit(view));
        } else {
            switch (view.getId()) {
                case R.id.ce:
                    display.clear();
                    calculator = new Calculator();
                    break;
                case R.id.backspace:
                    display.removeDigit();
                    break;
                default:
                    break;
            }
        }
        refresh();
    }

    private Integer selectedDigit(View view) {
        return DIGITS.get(view.getId());
    }

    private OPERATION selectedOperation(View v) {
        return MATH_OPERATIONS.get(v.getId());
    }

    private void refresh() {
        result.setText(display.getLine());
    }

}