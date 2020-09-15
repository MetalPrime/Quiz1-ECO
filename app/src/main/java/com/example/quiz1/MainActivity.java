package com.example.quiz1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView listParticipants;
    private Button register;
    private HashSet<String> usersTakes;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        listParticipants = findViewById(R.id.listParticipans);
        Log.e("Actual Shared",getSharedPreferences("Preferences",MODE_PRIVATE).getStringSet("ListUsers",new HashSet<String>()).toString());

        //Si toca reiniciar el sharedpreferences use está lines
        //getSharedPreferences("Preferences",MODE_PRIVATE).edit().clear().commit();

        usersTakes = (HashSet<String>) getSharedPreferences("Preferences",MODE_PRIVATE).getStringSet("ListUsers",new HashSet<String>());

        new Thread(
                () ->{
                    while(true){
                        if (usersTakes !=null) {
                            listParticipants.setText(usersTakes.toString() );

                        }
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

        ).start();



        register.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this,RegisterActivity.class);
                    startActivity(i);
                }
        );
    }
}