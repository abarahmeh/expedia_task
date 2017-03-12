package com.expedia.bean.offers.hotel;
/**
 * This provides methods to set & get the information for the URLs of Hotel
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class HotelUrls {
    private String hotelSearchResultUrl;
    private String hotelInfositeUrl;

    public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
        this.hotelSearchResultUrl = hotelSearchResultUrl;
    }

    public String getHotelSearchResultUrl() {
        return hotelSearchResultUrl;
    }

    public void setHotelInfositeUrl(String hotelInfositeUrl) {
        this.hotelInfositeUrl = hotelInfositeUrl;
    }

    public String getHotelInfositeUrl() {
        return hotelInfositeUrl;
    }
}
