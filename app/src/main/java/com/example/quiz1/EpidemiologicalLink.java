package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class EpidemiologicalLink extends AppCompatActivity {

    private Button continuar;
    private CheckBox ninguna;
    private CheckBox ch1,ch2,ch3,ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epidemiological_link);

        ch1 = findViewById(R.id.checkBox);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);
        ninguna = findViewById(R.id.checkBox5);
        continuar = findViewById(R.id.terminar);

        new Thread(
                () -> {
                    while (true){
                        if (ninguna.isChecked()){
                            ch1.setChecked(false);
                            ch2.setChecked(false);
                            ch3.setChecked(false);
                            ch4.setChecked(false);
                        }
                    }
                }

        ).start();

        continuar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,Symptoms.class);
                    startActivity(i);
                    finish();
                    /*if(!ninguna.isChecked() || !ch1.isChecked() || !ch4.isChecked() || !ch3.isChecked() || !ch2.isChecked()){
                        Toast.makeText(this,"Porfavor seleccione una casilla",Toast.LENGTH_LONG).show();
                    } else {

                    }*/
                }
        );




    }
}