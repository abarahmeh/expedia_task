package com.expedia.bean.offers.hotel;
/**
 * This provides methods to set & get the information for the Scores of Hotel
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class HotelScores {
    private double rawAppealScore;
    private double movingAverageScore;

    public void setRawAppealScore(double rawAppealScore) {
        this.rawAppealScore = rawAppealScore;
    }

    public double getRawAppealScore() {
        return rawAppealScore;
    }

    public void setMovingAverageScore(double movingAverageScore) {
        this.movingAverageScore = movingAverageScore;
    }

    public double getMovingAverageScore() {
        return movingAverageScore;
    }
}
