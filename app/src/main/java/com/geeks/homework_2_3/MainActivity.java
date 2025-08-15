package com.geeks.homework_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    private int a, b;
    private boolean isOperationClick;
    private int result;
    MaterialButton btn_minus;
    private String currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvResult = findViewById(R.id.tv_result);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn_one).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_two).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_three).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_four).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_five).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_six).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_seven).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_eight).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_nine).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_zero).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_ac).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_plus).setOnClickListener(v -> {
            onPlusClick();
            currentOperation = "+";
        });
        findViewById(R.id.btn_minus).setOnClickListener(v -> {
            onMinusClick();
            currentOperation = "-";
        });
        findViewById(R.id.btn_multiply).setOnClickListener(v -> {
            onMultiplyClick();
            currentOperation = "*";
        });
        findViewById(R.id.btn_divide).setOnClickListener(v -> {
            onDivideClick();
            currentOperation = "/";
        });
        findViewById(R.id.btn_equal).setOnClickListener(this::onEqualClick);
    }

    private void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            a = 0;
            b = 0;
            currentOperation = "";
            tvResult.setText("0");
        } else if (tvResult.getText().toString().equals("0") || isOperationClick) {
            tvResult.setText(text);
        }else {
            tvResult.append(text);
        }
        isOperationClick = false;
    }

    public void onPlusClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;
    }

    public void onMinusClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;
    }

    public void onMultiplyClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;
    }

    public void onDivideClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;
    }

    private void onEqualClick(View view) {
        b = Integer.parseInt(tvResult.getText().toString());
        switch (currentOperation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    tvResult.setText("Error");
                    return;
                }
                break;
        }
        tvResult.setText(String.valueOf(result));
        isOperationClick = true;
    }

}