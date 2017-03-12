package com.expedia.bean;

import java.util.List;
import com.expedia.bean.offers.Package;
import com.expedia.bean.offers.Hotel;
import com.expedia.bean.offers.Flight;

/**
 * This provides methods to set & get the information for Offers
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class Offers {
    private List<Package> packageList;
    private List<Hotel> hotelList;
    private List<Flight> flightList;
    

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

}
