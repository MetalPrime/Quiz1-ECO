package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Symptoms extends AppCompatActivity {

    private Button terminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        terminar = findViewById(R.id.terminar);

        terminar.setOnClickListener(
                (v)->{
                    finish();
                    /*if(!ninguna.isChecked() || !ch1.isChecked() || !ch4.isChecked() || !ch3.isChecked() || !ch2.isChecked()){
                        Toast.makeText(this,"Porfavor seleccione una casilla",Toast.LENGTH_LONG).show();
                    } else {

                    }*/
                }
        );
    }
}