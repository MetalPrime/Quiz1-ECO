package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EpidemiologicalLink extends AppCompatActivity {

    private Button continuar;
    private CheckBox ninguna;
    private CheckBox ch1,ch2,ch3,ch4;
    private int currentNote;
    private String identificationString, nameString;
    private boolean isOk;

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
        nameString = getIntent().getStringExtra("name");
        identificationString = getIntent().getStringExtra("identification");
        currentNote = 0;
        isOk = true;

        new Thread(
                () -> {
                    while (true) {
                        if (ninguna.isChecked()) {
                            ch1.setChecked(false);
                            ch2.setChecked(false);
                            ch3.setChecked(false);
                            ch4.setChecked(false);
                            currentNote = 0;
                        }


                    }

                }
                    ).start();


        new Thread(
                () ->{
                    while (isOk){
                        runOnUiThread(
                                () ->{

                                    if (ninguna.isChecked() || ch1.isChecked() || ch2.isChecked() || ch3.isChecked() || ch4.isChecked()){
                                        Log.e("status", "dandole bn");
                                        continuar.setBackgroundColor(Color.RED);
                                        continuar.setOnClickListener(
                                                (v) -> {
                                                    if (ch1.isChecked()) {
                                                        currentNote += 4;
                                                    }
                                                    if (ch2.isChecked()) {
                                                        currentNote += 4;
                                                    }
                                                    if (ch3.isChecked()) {
                                                        currentNote += 4;
                                                    }
                                                    if (ch4.isChecked()) {
                                                        currentNote += 4;
                                                    }

                                                    Intent i = new Intent(this, Symptoms.class);
                                                    startActivity(i);
                                                    i.putExtra("name", nameString);
                                                    i.putExtra("identification", identificationString);
                                                    i.putExtra("note", currentNote);
                                                    Log.e("status", currentNote + "");
                                                    finish();
                                                    isOk = false;

                                                }
                                        );

                                    } else {

                                        continuar.setBackgroundColor(Color.GRAY);
                                        Toast.makeText(this,"Porfavor seleccione una casilla",Toast.LENGTH_LONG).show();
                                        Log.e("status", "dandole mal");



                                    }



                                }


                        );

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
                        ).start();



                }



    }/////////Final|