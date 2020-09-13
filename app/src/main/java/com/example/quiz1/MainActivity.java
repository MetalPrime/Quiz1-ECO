package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView listParticipants;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        listParticipants = findViewById(R.id.listParticipans);

        register.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this,RegisterActivity.class);
                    startActivity(i);
                }
        );
    }
}