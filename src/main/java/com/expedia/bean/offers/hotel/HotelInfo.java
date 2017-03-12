package com.expedia.bean.offers.hotel;
/**
 * This provides methods to set & get the information for the Hotel
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class HotelInfo {
    private String travelStartDate;
    private String travelEndDate;
    private String statusDescription;
    private String statusCode;
    private int relevanceScore;
    private double rawAppealScore;
    private String promotionTag;
    private String promotionDescription;
    private double promotionAmount;
    private double movingAverageScore;
    private String language;
    private String hotelStreetAddress;
    private String hotelStarRating;
    private String hotelProvince;
    private String hotelName;
    private double hotelLongitude;
    private String hotelLongDestination;
    private String hotelLocation;
    private double hotelLatitude;
    private String hotelImageUrl;
    private String hotelId;
    private double hotelGuestReviewRating;
    private String hotelDestinationRegionID;
    private String hotelDestination;
    private String hotelCountryCode;
    private String hotelCity;
    private int distanceFromUser;
    private String description;
    private double carPackageScore;
    private boolean carPackage;
    private boolean allInclusive;
    
    public void setTravelStartDate(String travelStartDate) {
        this.travelStartDate = travelStartDate;
    }
    
    public String getTravelStartDate() {
        return travelStartDate;
    }

    public void setTravelEndDate(String travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public String getTravelEndDate() {
        return travelEndDate;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setRelevanceScore(int relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    public int getRelevanceScore() {
        return relevanceScore;
    }

    public void setRawAppealScore(double rawAppealScore) {
        this.rawAppealScore = rawAppealScore;
    }

    public double getRawAppealScore() {
        return rawAppealScore;
    }

    public void setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag;
    }

    public String getPromotionTag() {
        return promotionTag;
    }

    public void setPromotionDescription(String promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

    public String getPromotionDescription() {
        return promotionDescription;
    }

    public void setPromotionAmount(double promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public double getPromotionAmount() {
        return promotionAmount;
    }

    public void setMovingAverageScore(double movingAverageScore) {
        this.movingAverageScore = movingAverageScore;
    }

    public double getMovingAverageScore() {
        return movingAverageScore;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setHotelStreetAddress(String hotelStreetAddress) {
        this.hotelStreetAddress = hotelStreetAddress;
    }

    public String getHotelStreetAddress() {
        return hotelStreetAddress;
    }

    public void setHotelStarRating(String hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
    }

    public String getHotelStarRating() {
        return hotelStarRating;
    }

    public void setHotelProvince(String hotelProvince) {
        this.hotelProvince = hotelProvince;
    }

    public String getHotelProvince() {
        return hotelProvince;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelLongitude(double hotelLongitude) {
        this.hotelLongitude = hotelLongitude;
    }

    public double getHotelLongitude() {
        return hotelLongitude;
    }

    public void setHotelLongDestination(String hotelLongDestination) {
        this.hotelLongDestination = hotelLongDestination;
    }

    public String getHotelLongDestination() {
        return hotelLongDestination;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLatitude(double hotelLatitude) {
        this.hotelLatitude = hotelLatitude;
    }

    public double getHotelLatitude() {
        return hotelLatitude;
    }

    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelGuestReviewRating(double hotelGuestReviewRating) {
        this.hotelGuestReviewRating = hotelGuestReviewRating;
    }

    public double getHotelGuestReviewRating() {
        return hotelGuestReviewRating;
    }

    public void setHotelDestinationRegionID(String hotelDestinationRegionID) {
        this.hotelDestinationRegionID = hotelDestinationRegionID;
    }

    public String getHotelDestinationRegionID() {
        return hotelDestinationRegionID;
    }

    public void setHotelDestination(String hotelDestination) {
        this.hotelDestination = hotelDestination;
    }

    public String getHotelDestination() {
        return hotelDestination;
    }

    public void setHotelCountryCode(String hotelCountryCode) {
        this.hotelCountryCode = hotelCountryCode;
    }

    public String getHotelCountryCode() {
        return hotelCountryCode;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setDistanceFromUser(int distanceFromUser) {
        this.distanceFromUser = distanceFromUser;
    }

    public int getDistanceFromUser() {
        return distanceFromUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCarPackageScore(double carPackageScore) {
        this.carPackageScore = carPackageScore;
    }

    public double getCarPackageScore() {
        return carPackageScore;
    }

    public void setCarPackage(boolean carPackage) {
        this.carPackage = carPackage;
    }

    public boolean isCarPackage() {
        return carPackage;
    }

    public void setAllInclusive(boolean allInclusive) {
        this.allInclusive = allInclusive;
    }

    public boolean isAllInclusive() {
        return allInclusive;
    }
}
