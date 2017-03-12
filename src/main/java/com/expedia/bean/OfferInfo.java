package com.expedia.bean;
/**
 * This provides methods to set & get the information for Offer
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class OfferInfo {
    private String siteID;
    private String language;
    private String currency;

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
