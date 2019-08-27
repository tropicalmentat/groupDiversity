package com.appliedintelligence.domain;

public class Member {

    private String name;
    private Hobby hobby;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString(){
        return name + " interested in " + hobby;
    }
}
