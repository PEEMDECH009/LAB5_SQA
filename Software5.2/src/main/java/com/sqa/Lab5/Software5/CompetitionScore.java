package com.sqa.Lab5.Software5;



public class CompetitionScore {

    public int calculateScore(int score1, int score2, int score3) {

        if (score1 < 0 || score1 > 100)
            throw new IllegalArgumentException("Score1 must be between 0 and 100.");

        if (score2 < 0 || score2 > 100)
            throw new IllegalArgumentException("Score2 must be between 0 and 100.");

        if (score3 < 0 || score3 > 100)
            throw new IllegalArgumentException("Score3 must be between 0 and 100.");

        int max = Math.max(score1, Math.max(score2, score3));
        int min = Math.min(score1, Math.min(score2, score3));

        return score1 + score2 + score3 - max - min;
    }
}