package com.appliedintelligence.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class MemberAssignment {

    private Group group;
    private Member member;

    public Group getGroup(){
        return group;
    }

    @PlanningVariable
    public Member getMember(){
        return member;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    public void setMember(Member member){
        this.member = member;
    }


}
