package com.expedia.search.managedbean;

import com.expedia.bean.OfferInfo;
import com.expedia.bean.Offers;
import com.expedia.bean.OffersResults;
import com.expedia.bean.UserInfo;
import com.expedia.bean.offers.Destination;
import com.expedia.bean.offers.Hotel;
import com.expedia.bean.offers.OfferDateRange;
import com.expedia.bean.userinfo.Persona;
import com.expedia.bean.offers.hotel.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * This provides the business for Hotel search
 * And set & get methods for the attributes used in search page
 * And set & get methods for the search results to use in the search jsp page
 * This search depends on JAVA Api for json
 * This search depends on the entered values by the user in the search jsp page
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class SearchHotelMB {
    private OffersResults offersResults;
    private String destinationName;
    private String minTripStartDate;
    private String maxTripStartDate;
    private int lengthOfStay;
    private String minStarRating;
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }
    
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject json = new JSONObject(jsonText);
          return json;
        } finally {
          is.close();
        }
   }
    
    public void doSearch() {
        System.clearProperty("javax.net.ssl.trustStore");
        System.setProperty( "sun.security.ssl.allowUnsafeRenegotiation", "true" );
        try{
            String jsonURL = "http://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
            if(getDestinationName() != null && !getDestinationName().equals("")) {
                jsonURL = jsonURL + "&destinationName=" + getDestinationName();
            }
            if(getMinTripStartDate() != null && !getMinTripStartDate().equals("")) {
                jsonURL = jsonURL + "&minTripStartDate=" + getMinTripStartDate();
            }
            if(getMaxTripStartDate() != null && !getMaxTripStartDate().equals("")) {
                jsonURL = jsonURL + "&maxTripStartDate=" + getMaxTripStartDate();
            }
            if(getLengthOfStay() != 0) {
                jsonURL = jsonURL + "&lengthOfStay=" + getLengthOfStay();
            }
            if(getMinStarRating() != null && !getMinStarRating().equals("")) {
                jsonURL = jsonURL + "&minStarRating=" + getMinStarRating();
            }
            System.out.println(jsonURL);
            JSONObject json = readJsonFromUrl(jsonURL);
            OffersResults offersResults = new OffersResults();
            OfferInfo offerInfo = new OfferInfo();
            UserInfo userInfo = new UserInfo();
            Persona persona = new Persona();
            Offers offers = new Offers();
            List<Hotel> hotelList = new ArrayList<Hotel>();
            Hotel hotel = null;
            Destination destination = null;
            OfferDateRange offerDateRange = null;
            HotelInfo hotelInfo = null;
            HotelUrgencyInfo hotelUrgencyInfo = null;
            HotelPricingInfo hotelPricingInfo = null;
            HotelUrls hotelUrls = null;
            HotelScores hotelScores = null;
            
            JSONObject offerInfoObject = json.getJSONObject("offerInfo");
            JSONObject userInfoObject = json.getJSONObject("userInfo");
            JSONObject personaUserInfoObject = userInfoObject.getJSONObject("persona");
            JSONObject offersObject = json.getJSONObject("offers");
            JSONArray jsonHotelArray = offersObject.getJSONArray("Hotel");
            JSONObject offerDateRangeObject = null;
            JSONObject hotelUrlsObject = null;
            JSONObject hotelUrgencyInfoObject = null;
            JSONObject hotelScoresObject = null;
            JSONObject hotelPricingInfoObject = null;
            JSONObject hotelInfoObject = null;
            JSONObject destinationObject = null;
            
            offerInfo.setSiteID(offerInfoObject.getString("siteID"));
            offerInfo.setLanguage(offerInfoObject.getString("language"));
            offerInfo.setCurrency(offerInfoObject.getString("currency"));
            offersResults.setOfferInfo(offerInfo);
            //System.out.println(offersResults.getOfferInfo().getCurrency());
            
            
            userInfo.setUserId(userInfoObject.getString("userId"));
            persona.setPersonaType(personaUserInfoObject.getString("personaType"));
            userInfo.setPersona(persona);
            offersResults.setUserInfo(userInfo);
            //System.out.println(offersResults.getUserInfo().getUserId());
            //System.out.println(offersResults.getUserInfo().getPersona().getPersonaType());
            
            
            for(int i=0; i<jsonHotelArray.length(); i++){
                //System.out.println(jsonHotelArray.getJSONObject(i).getJSONObject("hotelInfo").get("hotelCity"));
                
                offerDateRangeObject = jsonHotelArray.getJSONObject(i).getJSONObject("offerDateRange");
                hotelUrlsObject = jsonHotelArray.getJSONObject(i).getJSONObject("hotelUrls");
                hotelUrgencyInfoObject = jsonHotelArray.getJSONObject(i).getJSONObject("hotelUrgencyInfo");
                hotelScoresObject = jsonHotelArray.getJSONObject(i).getJSONObject("hotelScores");
                hotelPricingInfoObject = jsonHotelArray.getJSONObject(i).getJSONObject("hotelPricingInfo");
                hotelInfoObject = jsonHotelArray.getJSONObject(i).getJSONObject("hotelInfo");
                destinationObject = jsonHotelArray.getJSONObject(i).getJSONObject("destination");
                
                hotel = new Hotel();
                offerDateRange = new OfferDateRange();
                hotelUrls = new HotelUrls();
                hotelUrgencyInfo = new HotelUrgencyInfo();
                hotelScores = new HotelScores();
                hotelPricingInfo = new HotelPricingInfo();
                hotelInfo = new HotelInfo();
                destination = new Destination();
                
                
                //Set the offerDateRange values for this hotel
                JSONArray jsonTravelStartDateArray = offerDateRangeObject.getJSONArray("travelStartDate");
                JSONArray jsonTravelEndDateArray = offerDateRangeObject.getJSONArray("travelEndDate");
                int[] travelStartDate = new int[jsonTravelStartDateArray.length()];
                int[] travelEndDate = new int[jsonTravelEndDateArray.length()];
                for(int x=0; x<jsonTravelStartDateArray.length(); x++) {
                    travelStartDate[x] = jsonTravelStartDateArray.getInt(x);
                }
                for(int x=0; x<jsonTravelEndDateArray.length(); x++) {
                    travelEndDate[x] = jsonTravelEndDateArray.getInt(x);
                }
                offerDateRange.setTravelStartDate(travelStartDate);
                offerDateRange.setTravelEndDate(travelEndDate);
                offerDateRange.setLengthOfStay(offerDateRangeObject.getInt("lengthOfStay"));
                
                //Set the hotelUrls values for this hotel
                hotelUrls.setHotelInfositeUrl(hotelUrlsObject.getString("hotelInfositeUrl"));
                hotelUrls.setHotelSearchResultUrl(hotelUrlsObject.getString("hotelSearchResultUrl"));
                
                //Set the hotelUrgencyInfo values for this hotel
                hotelUrgencyInfo.setAirAttachEnabled(hotelUrgencyInfoObject.getBoolean("airAttachEnabled"));
                hotelUrgencyInfo.setAirAttachRemainingTime(hotelUrgencyInfoObject.getInt("airAttachRemainingTime"));
                hotelUrgencyInfo.setAlmostSoldStatus(hotelUrgencyInfoObject.getString("almostSoldStatus"));
                hotelUrgencyInfo.setLastBookedTime(hotelUrgencyInfoObject.getInt("lastBookedTime"));
                hotelUrgencyInfo.setLink(hotelUrgencyInfoObject.getString("link"));
                hotelUrgencyInfo.setNumberOfPeopleBooked(hotelUrgencyInfoObject.getInt("numberOfPeopleBooked"));
                hotelUrgencyInfo.setNumberOfPeopleViewing(hotelUrgencyInfoObject.getInt("numberOfPeopleViewing"));
                hotelUrgencyInfo.setNumberOfRoomsLeft(hotelUrgencyInfoObject.getInt("numberOfRoomsLeft"));
                
                //Set the hotelScores values for this hotel
                hotelScores.setMovingAverageScore(hotelScoresObject.getDouble("movingAverageScore"));
                hotelScores.setRawAppealScore(hotelScoresObject.getDouble("rawAppealScore"));
                
                //Set the hotelPricingInfo values for this hotel
                hotelPricingInfo.setAveragePriceValue(hotelPricingInfoObject.getDouble("averagePriceValue"));
                hotelPricingInfo.setCurrency(hotelPricingInfoObject.getString("currency"));
                hotelPricingInfo.setDrr(hotelPricingInfoObject.getBoolean("drr"));
                hotelPricingInfo.setHotelTotalBaseRate(hotelPricingInfoObject.getDouble("hotelTotalBaseRate"));
                hotelPricingInfo.setHotelTotalMandatoryTaxesAndFees(hotelPricingInfoObject.getDouble("hotelTotalMandatoryTaxesAndFees"));
                hotelPricingInfo.setHotelTotalTaxesAndFees(hotelPricingInfoObject.getDouble("hotelTotalTaxesAndFees"));
                hotelPricingInfo.setOriginalPricePerNight(hotelPricingInfoObject.getString("originalPricePerNight"));
                hotelPricingInfo.setPercentSavings(hotelPricingInfoObject.getDouble("percentSavings"));
                hotelPricingInfo.setTotalPriceValue(hotelPricingInfoObject.getDouble("totalPriceValue"));
                
                //Set the hotelInfo values for this hotel
                hotelInfo.setAllInclusive(hotelInfoObject.getBoolean("allInclusive"));
                hotelInfo.setCarPackage(hotelInfoObject.getBoolean("carPackage"));
                hotelInfo.setCarPackageScore(hotelInfoObject.getDouble("carPackageScore"));
                hotelInfo.setDescription(hotelInfoObject.getString("description"));
                hotelInfo.setDistanceFromUser(hotelInfoObject.getInt("distanceFromUser"));
                hotelInfo.setHotelCity(hotelInfoObject.getString("hotelCity"));
                hotelInfo.setHotelCountryCode(hotelInfoObject.getString("hotelCountryCode"));
                hotelInfo.setHotelDestination(hotelInfoObject.getString("hotelDestination"));
                hotelInfo.setHotelDestinationRegionID(hotelInfoObject.getString("hotelDestinationRegionID"));
                hotelInfo.setHotelGuestReviewRating(hotelInfoObject.getDouble("hotelGuestReviewRating"));
                hotelInfo.setHotelId(hotelInfoObject.getString("hotelId"));
                hotelInfo.setHotelImageUrl(hotelInfoObject.getString("hotelImageUrl"));
                hotelInfo.setHotelLatitude(hotelInfoObject.getDouble("hotelLatitude"));
                hotelInfo.setHotelLocation(hotelInfoObject.getString("hotelLocation"));
                hotelInfo.setHotelLongDestination(hotelInfoObject.getString("hotelLongDestination"));
                hotelInfo.setHotelLongitude(hotelInfoObject.getDouble("hotelLongitude"));
                hotelInfo.setHotelName(hotelInfoObject.getString("hotelName"));
                hotelInfo.setHotelProvince(hotelInfoObject.getString("hotelProvince"));
                hotelInfo.setHotelStarRating(hotelInfoObject.getString("hotelStarRating"));
                hotelInfo.setHotelStreetAddress(hotelInfoObject.getString("hotelStreetAddress"));
                hotelInfo.setLanguage(hotelInfoObject.getString("language"));
                hotelInfo.setMovingAverageScore(hotelInfoObject.getDouble("movingAverageScore"));
                hotelInfo.setPromotionAmount(hotelInfoObject.getDouble("promotionAmount"));
                hotelInfo.setPromotionDescription(hotelInfoObject.getString("promotionDescription"));
                hotelInfo.setPromotionTag(hotelInfoObject.getString("promotionTag"));
                hotelInfo.setRawAppealScore(hotelInfoObject.getDouble("rawAppealScore"));
                hotelInfo.setRelevanceScore(hotelInfoObject.getInt("relevanceScore"));
                hotelInfo.setStatusCode(hotelInfoObject.getString("statusCode"));
                hotelInfo.setStatusDescription(hotelInfoObject.getString("statusDescription"));
                hotelInfo.setTravelEndDate(hotelInfoObject.getString("travelEndDate"));
                hotelInfo.setTravelStartDate(hotelInfoObject.getString("travelStartDate"));
                
                //Set the destination values for this hotel
                destination.setCity(destinationObject.getString("city"));
                destination.setCountry(destinationObject.getString("country"));
                destination.setLongName(destinationObject.getString("longName"));
                destination.setProvince(destinationObject.getString("province"));
                destination.setRegionID(destinationObject.getString("regionID"));
                
                
                hotel.setDestination(destination);
                hotel.setHotelInfo(hotelInfo);
                hotel.setHotelPricingInfo(hotelPricingInfo);
                hotel.setHotelScores(hotelScores);
                hotel.setHotelUrgencyInfo(hotelUrgencyInfo);
                hotel.setHotelUrls(hotelUrls);
                hotel.setOfferDateRange(offerDateRange);
                hotelList.add(hotel);
            }
            
            //Sort the hotelList depending on TotalPriceValue
            Collections.sort(hotelList, new Comparator<Hotel>(){
                 public int compare(Hotel o1, Hotel o2){
                     if(o1.getHotelPricingInfo().getTotalPriceValue() == o2.getHotelPricingInfo().getTotalPriceValue())
                         return 0;
                     return o1.getHotelPricingInfo().getTotalPriceValue() < o2.getHotelPricingInfo().getTotalPriceValue() ? -1 : 1;
                 }
            });
            
            offers.setHotelList(hotelList);
            offersResults.setOffers(offers);
            setOffersResults(offersResults);
        }catch(JSONException ex) {
            ex.printStackTrace();        
        }catch(IOException ex) {
                ex.printStackTrace();
        }
    }
    
    public void setOffersResults(OffersResults offersResults) {
        this.offersResults = offersResults;
    }

    public OffersResults getOffersResults() {
        return offersResults;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationName() {
        return destinationName;
    }


    public void setMinTripStartDate(String minTripStartDate) {
        this.minTripStartDate = minTripStartDate;
    }

    public String getMinTripStartDate() {
        return minTripStartDate;
    }

    public void setMaxTripStartDate(String maxTripStartDate) {
        this.maxTripStartDate = maxTripStartDate;
    }

    public String getMaxTripStartDate() {
        return maxTripStartDate;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setMinStarRating(String minStarRating) {
        this.minStarRating = minStarRating;
    }

    public String getMinStarRating() {
        return minStarRating;
    }
}
