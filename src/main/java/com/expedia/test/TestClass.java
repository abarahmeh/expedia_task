package com.expedia.test;

import com.expedia.bean.OfferInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestClass {
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

      public static void main(String[] args) throws IOException, JSONException {
        System.clearProperty("javax.net.ssl.trustStore");
        System.setProperty( "sun.security.ssl.allowUnsafeRenegotiation", "true" );
        JSONObject json = readJsonFromUrl("https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel");
        
        System.out.println(json.toString());
        System.out.println(json.get("offerInfo"));
        
        
        JSONObject jSONObject = json.getJSONObject("offers");
        System.out.println(jSONObject);
        Object level = jSONObject.get("Hotel");
        System.out.println(level);
        
        
        OfferInfo offerInfo = new OfferInfo();
        JSONObject offerInfoObject = json.getJSONObject("offerInfo");
        offerInfo.setSiteID(offerInfoObject.getString("siteID"));
        System.out.println(offerInfo.getSiteID());
        
        JSONObject hotelObject = json.getJSONObject("offers");
        System.out.println(hotelObject.get("Hotel"));
        JSONArray jsonArray = hotelObject.getJSONArray("Hotel");
        System.out.println(jsonArray.length());
        for(int i=0; i<jsonArray.length(); i++){
            System.out.println(jsonArray.getJSONObject(i).getJSONObject("hotelInfo").get("hotelCity"));
        }
        
        

    }
}