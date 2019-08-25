package com.appliedintelligence.domain;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
@XStreamAlias("MemberAssignmentSolution")
public class MemberAssignmentSolution {

    private List<Group> groupList;
    private List<Member> memberList;
    private List<MemberAssignment> memberAssignmentList;

    private HardSoftScore score;

    public MemberAssignmentSolution(){
        groupList = new ArrayList<>();
        memberList = new ArrayList<>();
        memberAssignmentList = new ArrayList<>();
    }

    @PlanningEntityCollectionProperty
    public List<MemberAssignment> getAssignmentList(){
        return memberAssignmentList;
    }

//    @ValueRangeProvider(id="availableGroups")
    @ProblemFactCollectionProperty
    public List<Group> getGroupList(){
        return groupList;
    }

    @ValueRangeProvider(id="availableMembers")
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

    public void printMemberAssignment(){
        for (MemberAssignment assignment:memberAssignmentList){
            System.out.println(assignment.getMember().getName()
                    + " is assigned to " +
                    assignment.getGroup().getGroupIndex());
        }
    }
}
