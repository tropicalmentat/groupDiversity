package com.appliedintelligence.domain;

public class Group {

    private int groupIndex;
    private int memberCapacity = 7;

    public int getGroupIndex() {
        return groupIndex;
    }

    public int getMemberCapacity(){
        return memberCapacity;
    }

    public void setMemberCapacity(int i){
        this.memberCapacity = i;
    }

    public void setGroupIndex(int i){
        this.groupIndex = i;
    }

}
