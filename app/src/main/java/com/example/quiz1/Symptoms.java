package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Symptoms extends AppCompatActivity {

    private Button terminar;
    private CheckBox respirar,fiebre,garganta,nasal,tos,fatiga;
    private CheckBox ninguno;
    private boolean isOk;
    private String identificationString,nameString;
    private int noteString;

    private SharedPreferences preferences;
    private SharedPreferences.Editor userPreferences;
    private ArrayList<String> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        terminar = findViewById(R.id.terminar);
        respirar = findViewById(R.id.checkBoxRespirar);
        fiebre = findViewById(R.id.checkBoxFiebre);
        garganta = findViewById(R.id.checkBoxGarganta);
        nasal = findViewById(R.id.checkBoxNasal);
        tos = findViewById(R.id.checkBoxTos);
        fatiga = findViewById(R.id.checkBoxFatiga);
        ninguno = findViewById(R.id.checkBoxNinguno);

        isOk = true;

        identificationString = getIntent().getStringExtra("identification");
        nameString = getIntent().getStringExtra("name");
        noteString = Integer.parseInt((getIntent().getStringExtra("note")));
        Log.e("Actual NOota",noteString+"");

        preferences = getSharedPreferences("Preferences",MODE_PRIVATE);

        users = new ArrayList<>();

        final Set<String> set = preferences.getStringSet("ListUsers",null);

        if (set == null){
            users = new ArrayList<>();
        } else {
            users = new ArrayList<>(set);
        }

        new Thread(
                () -> {
                    while (true){
                                    if (ninguno.isChecked()){
                                        respirar.setChecked(false);
                                        fiebre.setChecked(false);
                                        garganta.setChecked(false);
                                        nasal.setChecked(false);
                                        tos.setChecked(false);
                                        fatiga.setChecked(false);
                                    }



                    }
                }

        ).start();

        new Thread(
                () ->{
                    while (isOk){
                        runOnUiThread(
                                () ->{

                                    if (ninguno.isChecked() || respirar.isChecked() || fiebre.isChecked() || garganta.isChecked() || nasal.isChecked() || tos.isChecked() || fatiga.isChecked()){
                                        Log.e("status", "dandole bn");
                                        terminar.setBackgroundColor(Color.RED);
                                        terminar.setOnClickListener(
                                                (v) -> {
                                                    if (respirar.isChecked()) {
                                                        noteString += 3;
                                                    }
                                                    if (fiebre.isChecked()) {
                                                        noteString += 3;
                                                    }
                                                    if (garganta.isChecked()) {
                                                        noteString += 3;
                                                    }
                                                    if (nasal.isChecked()) {
                                                        noteString += 3;
                                                    }
                                                    if (tos.isChecked()) {
                                                        noteString += 3;
                                                    }
                                                    if (fatiga.isChecked()) {
                                                        noteString += 3;
                                                    }



                                                    Set<String>set1 = new HashSet<>();

                                                    users.add(nameString+" "+identificationString + " " + noteString+ "\n");

                                                    Log.e("status", users.get(0));
                                                    /* users.add(); */

                                                    assert set1 != null;

                                                        set1.addAll(users);
                                                        preferences.edit().putStringSet("ListUsers", set1).apply();

                                                        Log.e("Actual Shared",preferences.getStringSet("ListUsers",null).toString());

                                                    isOk = false;
                                                    finish();





                                                }
                                        );

                                    } else {

                                        terminar.setBackgroundColor(Color.GRAY);
                                        Toast.makeText(this,"Porfavor seleccione una casilla",Toast.LENGTH_LONG).show();
                                        Log.e("status", "dandole mal");



                                    }



                                }


                        );

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
        ).start();



    }
}