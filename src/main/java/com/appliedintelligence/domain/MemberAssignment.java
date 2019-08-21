package com.appliedintelligence.domain;

import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class MemberAssignment {

    private ArrayList<Group> groupList;
    private ArrayList<Member> memberList;
    private HardSoftScore score;

    public List<Group> getGroupList(){
        return groupList;
    }

    @ValueRangeProvider(id = "availableMembers")
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
