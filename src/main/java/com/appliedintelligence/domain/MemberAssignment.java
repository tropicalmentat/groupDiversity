package com.appliedintelligence.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class MemberAssignment {

    private String assignmentID;
    private Group group;
    private Member member;

    public MemberAssignment(){
    }

    public String getAssignmentID(){
        return assignmentID;
    }

    public void setAssignmentID(String i){
        this.assignmentID = i;
    }

//    @PlanningVariable(valueRangeProviderRefs = {"availableGroups"})
    public Group getGroup(){
        return group;
    }

    @PlanningVariable(valueRangeProviderRefs = {"availableMembers"})
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
