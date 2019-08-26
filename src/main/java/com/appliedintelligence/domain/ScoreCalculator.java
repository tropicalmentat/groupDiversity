package com.appliedintelligence.domain;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.ArrayList;
import java.util.HashSet;

public class ScoreCalculator implements EasyScoreCalculator<MemberAssignmentSolution> {

    public Score calculateScore(MemberAssignmentSolution memberAssignmentSolution){

        int simpleScore = 0;

        /*
        Hard Constraints:
        1. A member can only belong to one group
        2. Each group can hold a maximum of 7 members only
        3. Each group should have more than 1 member
         */

        ArrayList<MemberAssignment> assignmentList = new ArrayList<>();
        HashSet<String> assignedMember = new HashSet<>();

        for (Group group:memberAssignmentSolution.getGroupList()){

            if (group.getMemberCapacity()>=7){
                simpleScore+=-1;
            }

            for (Member member:memberAssignmentSolution.getMemberList()){

                if (group.getMemberCapacity()<0){
                    simpleScore+=-1;
                }

                String assignment = member.getName()+":"+group.getGroupIndex();

                if (assignedMember.contains(member.getName())){
                    simpleScore += -1;
                    System.out.println(member.getName() + " is already assigned to a group!");
                }
                else if (group.getMemberCapacity()>=1) {

                    assignedMember.add(member.getName());

                    group.setMemberCapacity(group.getMemberCapacity() - 1);

//                    System.out.println(group.getGroupIndex() + " has " + group.getMemberCapacity() + " capacity");
                }
            }
        }
        return SimpleScore.valueOf(simpleScore);
    }
}
