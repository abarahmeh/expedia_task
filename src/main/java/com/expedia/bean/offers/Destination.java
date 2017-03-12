package com.expedia.bean.offers;
/**
 * This provides methods to set & get the information for the Destination
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class Destination {
    private String regionID;
    private String province;
    private String longName;
    private String country;
    private String city;

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getLongName() {
        return longName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
