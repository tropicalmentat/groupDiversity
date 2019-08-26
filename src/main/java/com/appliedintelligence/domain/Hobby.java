package com.appliedintelligence.domain;

public enum Hobby {
    READING("1"),
    VOLUNTEERING("2");

    public static Hobby valueOfCode(String code){
        for (Hobby hobby:values()){
            if(code.equalsIgnoreCase(hobby.getCode())){
                return hobby;
            }
        }
        return null;
    }

    private String code;

    private Hobby(String code){
        this.code=code;
    }

    public String getCode(){
        return code;
    }

    public String getLabel(){
        return name();
    }
}
