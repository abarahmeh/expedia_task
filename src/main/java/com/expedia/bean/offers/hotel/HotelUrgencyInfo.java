package com.expedia.bean.offers.hotel;
/**
 * This provides methods to set & get the information for the Urgency Info of Hotel
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class HotelUrgencyInfo {
    private int numberOfRoomsLeft;
    private int numberOfPeopleViewing;
    private int numberOfPeopleBooked;
    private String link;
    private int lastBookedTime;
    private String almostSoldStatus;
    private int airAttachRemainingTime;
    private boolean airAttachEnabled;

    public void setNumberOfRoomsLeft(int numberOfRoomsLeft) {
        this.numberOfRoomsLeft = numberOfRoomsLeft;
    }

    public int getNumberOfRoomsLeft() {
        return numberOfRoomsLeft;
    }

    public void setNumberOfPeopleViewing(int numberOfPeopleViewing) {
        this.numberOfPeopleViewing = numberOfPeopleViewing;
    }

    public int getNumberOfPeopleViewing() {
        return numberOfPeopleViewing;
    }

    public void setNumberOfPeopleBooked(int numberOfPeopleBooked) {
        this.numberOfPeopleBooked = numberOfPeopleBooked;
    }

    public int getNumberOfPeopleBooked() {
        return numberOfPeopleBooked;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLastBookedTime(int lastBookedTime) {
        this.lastBookedTime = lastBookedTime;
    }

    public int getLastBookedTime() {
        return lastBookedTime;
    }

    public void setAlmostSoldStatus(String almostSoldStatus) {
        this.almostSoldStatus = almostSoldStatus;
    }

    public String getAlmostSoldStatus() {
        return almostSoldStatus;
    }

    public void setAirAttachEnabled(boolean airAttachEnabled) {
        this.airAttachEnabled = airAttachEnabled;
    }

    public boolean isAirAttachEnabled() {
        return airAttachEnabled;
    }

    public void setAirAttachRemainingTime(int airAttachRemainingTime) {
        this.airAttachRemainingTime = airAttachRemainingTime;
    }

    public int getAirAttachRemainingTime() {
        return airAttachRemainingTime;
    }
}
