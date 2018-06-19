package com.devskiller.calculator.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Calculator calculator = new Calculator();
    private Display display = new Display();

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        findViewById(R.id.ce).setOnClickListener(this);
        findViewById(R.id.backspace).setOnClickListener(this);
        for (int id : ButtonsMapping.MATH_OPERATIONS.keySet()) {
            findViewById(id).setOnClickListener(this);
        }
        for (int id : ButtonsMapping.DIGITS.keySet()) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        // TODO: To be implemented
    }

    private Integer selectedDigit(View view) {
        return ButtonsMapping.DIGITS.get(view.getId());
    }

    private Operation selectedOperation(View v) {
        return ButtonsMapping.MATH_OPERATIONS.get(v.getId());
    }

    private void refresh() {
        result.setText(display.getLine());
    }
}