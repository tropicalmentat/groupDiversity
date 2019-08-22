package com.appliedintelligence.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

public class Group {

    private int groupIndex;

    public int getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(int i){
        this.groupIndex = i;
    }

}
