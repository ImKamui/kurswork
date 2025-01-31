package com.example.kursach;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import java.lang.String;
public class UserNameActivity extends AppCompatActivity{
    private EditText usernameText; // Поле для ввода имени пользователя
    String username = new String(); // Переменная для сохранения имени пользователя
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        usernameText = findViewById(R.id.editTextText);
        username = String.valueOf(usernameText);

        Button buttonMeet = findViewById(R.id.button);
        buttonMeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMainActivity();
            }
        });
    }
    public void OpenMainActivity()
    {
        Intent usernameIntent = new Intent(this, MainActivity.class);
        usernameIntent.putExtra("username", username);
        startActivity(usernameIntent);
    }
}
