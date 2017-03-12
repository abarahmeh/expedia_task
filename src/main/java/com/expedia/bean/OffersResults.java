package com.expedia.bean;
/**
 * This provides methods to set & get the information for Offers to use in the search
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class OffersResults {
    private OfferInfo offerInfo;
    private UserInfo userInfo;
    private Offers offers;

    public void setOfferInfo(OfferInfo offerInfo) {
        this.offerInfo = offerInfo;
    }

    public OfferInfo getOfferInfo() {
        return offerInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public Offers getOffers() {
        return offers;
    }
}
