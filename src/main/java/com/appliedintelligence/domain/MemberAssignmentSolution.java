package com.appliedintelligence.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class MemberAssignmentSolution {

    private List<Group> groupList;
    private List<Member> memberList;
    private HardSoftScore score;

    @PlanningEntityCollectionProperty
    private List<MemberAssignment> memberAssigmnmentList;

    @ProblemFactCollectionProperty
    public List<Group> getGroupList(){
        return groupList;
    }

    @ProblemFactCollectionProperty
    public List<Member> getMemberList(){
        return memberList;
    }

    @PlanningScore
    public HardSoftScore getScore(){
        return score;
    }

    public void setScore(HardSoftScore score){
        this.score = score;
    }
}
