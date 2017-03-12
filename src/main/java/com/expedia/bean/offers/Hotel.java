package com.expedia.bean.offers;

import com.expedia.bean.offers.hotel.HotelInfo;
import com.expedia.bean.offers.hotel.HotelPricingInfo;
import com.expedia.bean.offers.hotel.HotelScores;
import com.expedia.bean.offers.hotel.HotelUrgencyInfo;
import com.expedia.bean.offers.hotel.HotelUrls;
/**
 * This provides methods to set & get the information for the Hotel offers
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class Hotel {
    private HotelInfo hotelInfo;
    private HotelUrgencyInfo hotelUrgencyInfo;
    private HotelPricingInfo hotelPricingInfo;
    private HotelUrls hotelUrls;
    private HotelScores hotelScores;
    private Destination destination;
    private OfferDateRange offerDateRange;

    public void setHotelInfo(HotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelUrgencyInfo(HotelUrgencyInfo hotelUrgencyInfo) {
        this.hotelUrgencyInfo = hotelUrgencyInfo;
    }

    public HotelUrgencyInfo getHotelUrgencyInfo() {
        return hotelUrgencyInfo;
    }

    public void setHotelPricingInfo(HotelPricingInfo hotelPricingInfo) {
        this.hotelPricingInfo = hotelPricingInfo;
    }

    public HotelPricingInfo getHotelPricingInfo() {
        return hotelPricingInfo;
    }

    public void setHotelUrls(HotelUrls hotelUrls) {
        this.hotelUrls = hotelUrls;
    }

    public HotelUrls getHotelUrls() {
        return hotelUrls;
    }

    public void setHotelScores(HotelScores hotelScores) {
        this.hotelScores = hotelScores;
    }

    public HotelScores getHotelScores() {
        return hotelScores;
    }
    
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setOfferDateRange(OfferDateRange offerDateRange) {
        this.offerDateRange = offerDateRange;
    }

    public OfferDateRange getOfferDateRange() {
        return offerDateRange;
    }
}
