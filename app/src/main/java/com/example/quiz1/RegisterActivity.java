package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText identification;
    private Button continuar;

    private String identificationString,nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        identification = findViewById(R.id.identification);
        continuar = findViewById(R.id.terminar);

        continuar.setOnClickListener(
                (v) -> {
                    if(name.getText().toString().equals("") && identification.getText().toString().equals("")){
                        Toast.makeText(this,"Porfavor dijite un nombre o identificación",Toast.LENGTH_LONG).show();
                    } else {

                        Intent i = new Intent(this,EpidemiologicalLink.class);
                        nameString = name.getText().toString();
                        identificationString = identification.getText().toString();
                        i.putExtra("name",nameString);
                        i.putExtra("identification",identificationString);
                        startActivity(i);
                        finish();

                    }
                }
        );
    }
}