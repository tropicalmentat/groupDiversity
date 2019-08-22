package com.appliedintelligence.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

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
