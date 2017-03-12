package com.expedia.bean.offers;
/**
 * This provides methods to set & get the information for the Date Range of offers
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class OfferDateRange {
    private int[] travelStartDate;
    private int[] travelEndDate;
    private int lengthOfStay;

    public void setTravelStartDate(int[] travelStartDate) {
        this.travelStartDate = travelStartDate;
    }

    public int[] getTravelStartDate() {
        return travelStartDate;
    }

    public void setTravelEndDate(int[] travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public int[] getTravelEndDate() {
        return travelEndDate;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }
}
