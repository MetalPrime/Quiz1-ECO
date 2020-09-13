package com.example.quiz1;

import android.content.SharedPreferences;

public class User {

    private String name;
    private String identification;
    private int finalNote;
    SharedPreferences preferences;

    public User(String name,String identification){
        this.name = name;
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
