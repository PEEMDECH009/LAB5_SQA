package com.sqa.Lab5.Software5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CompetitionScoreStrongRobustTest {

    CompetitionScore score = new CompetitionScore();

    // ---------- Score1 ----------

    @Test
    void TC01_BelowMin() {
        assertThrows(IllegalArgumentException.class,
                () -> score.calculateScore(-1, 50, 50));
    }

    @Test
    void TC02_Min() {
        assertEquals(50,
                score.calculateScore(0, 50, 50));
    }

    @Test
    void TC03_MinPlusOne() {
        assertEquals(50,
                score.calculateScore(1, 50, 50));
    }

    @Test
    void TC04_Nominal() {
        assertEquals(50,
                score.calculateScore(50, 50, 50));
    }

    @Test
    void TC05_MaxMinusOne() {
        assertEquals(50,
                score.calculateScore(99, 50, 50));
    }

    @Test
    void TC06_Max() {
        assertEquals(50,
                score.calculateScore(100, 50, 50));
    }

    @Test
    void TC07_AboveMax() {
        assertThrows(IllegalArgumentException.class,
                () -> score.calculateScore(101, 50, 50));
    }

    // ---------- Score2 ----------

    @Test
    void TC08_BelowMin() {
        assertThrows(IllegalArgumentException.class,
                () -> score.calculateScore(50, -1, 50));
    }

    @Test
    void TC09_AboveMax() {
        assertThrows(IllegalArgumentException.class,
                () -> score.calculateScore(50, 101, 50));
    }

    // ---------- Score3 ----------

    @Test
    void TC10_BelowMin() {
        assertThrows(IllegalArgumentException.class,
                () -> score.calculateScore(50, 50, -1));
    }

    @Test
    void TC11_AboveMax() {
        assertThrows(IllegalArgumentException.class,
                () -> score.calculateScore(50, 50, 101));
    }

    // ---------- ทุกค่าที่ขอบเขต ----------

    @Test
    void TC12_AllMinimum() {
        assertEquals(0,
                score.calculateScore(0, 0, 0));
    }

    @Test
    void TC13_AllMaximum() {
        assertEquals(100,
                score.calculateScore(100, 100, 100));
    }

    @Test
    void TC14_MixedBoundary() {
        assertEquals(50,
                score.calculateScore(0, 50, 100));
    }

}