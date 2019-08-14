package com.appliedintelligence;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class GroupAssignment {

    private Member member;
    private Group group;

    @PlanningVariable
    private Member getMember(){
        return member;
    }

    @PlanningVariable
    private Group getGroup(){
        return group;
    }
}
