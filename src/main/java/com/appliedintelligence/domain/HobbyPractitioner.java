package com.appliedintelligence.domain;

public class HobbyPractitioner {

    private Member member;
    private Hobby hobby;

    public Member getMember(){
        return member;
    }

    public void setMember(Member member){
        this.member = member;
    }

    public Hobby getHobby(){
        return hobby;
    }

    public void setHobby(Hobby hobby){
        this.hobby = hobby;
    }

    @Override
    public String toString(){
        return member.getName() + '-' + hobby;
    }
}
