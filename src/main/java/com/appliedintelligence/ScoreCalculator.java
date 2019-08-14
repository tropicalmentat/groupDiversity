package com.appliedintelligence;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class ScoreCalculator implements EasyScoreCalculator<GroupAssignment>{

    @Override
    public Score calculateScore(GroupAssignment groupAssignment){
        int hardScore = 0;
        int softScore = 0;

        return HardSoftScore.valueOf(hardScore,softScore);
    }


}
