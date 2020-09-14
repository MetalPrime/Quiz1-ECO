package com.example.quiz1;

public class User {

    private String name;
    private String identification;
    private int finalNote;

    public User(String name,String identification,int finalNote){
        this.name = name;
        this.identification = identification;
        this.finalNote = finalNote;
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
