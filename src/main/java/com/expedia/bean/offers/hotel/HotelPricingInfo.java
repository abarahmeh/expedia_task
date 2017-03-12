package com.expedia.bean.offers.hotel;
/**
 * This provides methods to set & get the information for the Pricing Info of Hotel
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class HotelPricingInfo {
    private double totalPriceValue;
    private double percentSavings;
    private String originalPricePerNight;
    private double hotelTotalTaxesAndFees;
    private double hotelTotalMandatoryTaxesAndFees;
    private double hotelTotalBaseRate;
    private boolean drr;
    private String currency;
    private double averagePriceValue;

    public void setTotalPriceValue(double totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    public double getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setPercentSavings(double percentSavings) {
        this.percentSavings = percentSavings;
    }

    public double getPercentSavings() {
        return percentSavings;
    }

    public void setOriginalPricePerNight(String originalPricePerNight) {
        this.originalPricePerNight = originalPricePerNight;
    }

    public String getOriginalPricePerNight() {
        return originalPricePerNight;
    }

    public void setHotelTotalTaxesAndFees(double hotelTotalTaxesAndFees) {
        this.hotelTotalTaxesAndFees = hotelTotalTaxesAndFees;
    }

    public double getHotelTotalTaxesAndFees() {
        return hotelTotalTaxesAndFees;
    }

    public void setHotelTotalMandatoryTaxesAndFees(double hotelTotalMandatoryTaxesAndFees) {
        this.hotelTotalMandatoryTaxesAndFees = hotelTotalMandatoryTaxesAndFees;
    }

    public double getHotelTotalMandatoryTaxesAndFees() {
        return hotelTotalMandatoryTaxesAndFees;
    }

    public void setHotelTotalBaseRate(double hotelTotalBaseRate) {
        this.hotelTotalBaseRate = hotelTotalBaseRate;
    }

    public double getHotelTotalBaseRate() {
        return hotelTotalBaseRate;
    }

    public void setDrr(boolean drr) {
        this.drr = drr;
    }

    public boolean isDrr() {
        return drr;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAveragePriceValue(double averagePriceValue) {
        this.averagePriceValue = averagePriceValue;
    }

    public double getAveragePriceValue() {
        return averagePriceValue;
    }
}
