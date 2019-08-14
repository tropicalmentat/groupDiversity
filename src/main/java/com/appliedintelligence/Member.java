package com.appliedintelligence;

public class Member {

    private String name;
    private Passion passion;
//    private String activity;
//    private int tenure;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passion getPassion(){
        return passion;
    }

    public void setPassion(Passion passion) {
        this.passion = passion;
    }
}
