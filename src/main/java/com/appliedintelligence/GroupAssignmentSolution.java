package com.appliedintelligence;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

public class GroupAssignmentSolution {

    private List<Member> memberList;
    private List<Group> groupList;

    private HardSoftScore score;

    @PlanningEntityCollectionProperty
    public List<Member> getMemberList(){
        return memberList;
    }

    public void setMemberList(List<Member> memberList){
        this.memberList = memberList;
    }

    @ProblemFactCollectionProperty
    public List<Group> groupList(){
        return groupList;
    }

    public void setGroupList(List<Group> groupList){
        this.groupList = groupList;
    }

    @PlanningScore
    public HardSoftScore getScore(){
        return score;
    }

    public void setScore(HardSoftScore score){
        this.score = score;
    }

}
