package com.appliedintelligence.domain;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class ScoreCalculator implements EasyScoreCalculator<MemberAssignmentSolution> {

    public Score calculateScore(MemberAssignmentSolution memberAssignmentSolution){
        int hardScore = 0;
        int softScore = 0;

        /*
        Hard Constraints:
        1. A member can only belong to one group
        2. Each group can hold a maximum of 7 members only
        3. Each group should have more than 1 member
         */



        return HardSoftScore.valueOf(hardScore,softScore);
    }
}
