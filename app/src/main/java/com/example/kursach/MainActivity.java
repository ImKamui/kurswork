package com.example.kursach;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView usernameText;
    private TextView firstOperand;
    private TextView secondOperand;
    private TextView operationText;
    private TextView equalText;
    private TextView resultText;
    private EditText resultEdit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultEdit = findViewById(R.id.resultEditText);
        usernameText = findViewById(R.id.textView2);
        usernameText.setText("Привет! Приятно познакомиться, " + getIntent().getStringExtra("username") + "! Меня зовут Гиппо. Давай поиграем?");
        firstOperand = findViewById(R.id.firstOperand);
        secondOperand = findViewById(R.id.secondOperand);
        operationText = findViewById(R.id.operationText);
        equalText = findViewById(R.id.equalText);
        resultText = findViewById(R.id.resultText);
        Button buttonPlay = findViewById(R.id.buttonPlay);
        Button buttonAccept = findViewById(R.id.buttonAccept);
        Button buttonExit = findViewById(R.id.buttonExit);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play();
            }
        });

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result();
            }
        });
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Play(){
        char[] symbols = {'+', '-', '*', '/'};
        Random random = new Random();
        int randomIndex = random.nextInt(symbols.length);
        char randomSymb = symbols[randomIndex];
        int firstInt = new Random().nextInt(100 - 1 + 1) + 1;
        int secondInt = new Random().nextInt(100 - 1 + 1) + 1;
        firstOperand.setText(String.valueOf(firstInt));
        operationText.setText(String.valueOf(randomSymb));
        secondOperand.setText(String.valueOf(secondInt));
        equalText.setText("=");
        resultText.setText("");
        resultEdit.setText("");
    }

    private void Result()
    {
        int result = Integer.parseInt(resultEdit.getText().toString());
        int first = Integer.parseInt(firstOperand.getText().toString());
        int second = Integer.parseInt(secondOperand.getText().toString());
        String oper = operationText.getText().toString();
        switch (oper)
        {
            case "+":
                if (result == first + second)
                {
                    resultText.setText(String.valueOf(result));
                    usernameText.setText("Молодец, " + getIntent().getStringExtra("username") + "! Ты решил эту задачу!");
                }
                else {
                    usernameText.setText("О нет, " + getIntent().getStringExtra("username") + ", это неверно! Попробуй ещё раз!");
                }
                break;
            case "-":
                if (result == first - second)
                {
                    resultText.setText(String.valueOf(result));
                    usernameText.setText("Молодец, " + getIntent().getStringExtra("username") + "! Ты решил эту задачу!");
                }
                else {
                    usernameText.setText("О нет, " + getIntent().getStringExtra("username") + ", это неверно! Попробуй ещё раз!");
                }
                break;
            case "*":
                if (result == first * second)
                {
                    resultText.setText(String.valueOf(result));
                    usernameText.setText("Молодец, " + getIntent().getStringExtra("username") + "! Ты решил эту задачу!");
                }
                else {
                    usernameText.setText("О нет, " + getIntent().getStringExtra("username") + ", это неверно! Попробуй ещё раз!");
                }
                break;
            case "/":
                if (result == first / second)
                {
                    resultText.setText(String.valueOf(result));
                    usernameText.setText("Молодец, " + getIntent().getStringExtra("username") + "! Ты решил эту задачу!");
                }
                else {
                    usernameText.setText("О нет, " + getIntent().getStringExtra("username") + ", это неверно! Попробуй ещё раз!");
                }
                break;
        }

    }


}