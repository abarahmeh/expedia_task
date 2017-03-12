package com.expedia.search;

import com.expedia.search.managedbean.SearchHotelMB;
import com.expedia.bean.OffersResults;

import com.expedia.bean.offers.Hotel;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * This Java servlet provides the business for doing the Hotel search
 * It's passing the entered values from the user to do the search depending on them
 * Then it's return the results of hotels as table at the same page
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class SearchHotel extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            
            String destinationName = request.getParameter("destinationName");
            String minTripStartDate = request.getParameter("minTripStartDate");
            String maxTripStartDate = request.getParameter("maxTripStartDate"); 
            int lengthOfStay = 0;
            //Parse the lengthOfStay to be integer value
            try{
                lengthOfStay = Integer.parseInt(request.getParameter("lengthOfStay"));
            }catch(Exception ex) {
                //ex.printStackTrace();
            }
            
            String minStarRating = request.getParameter("minStarRating");
            
            SearchHotelMB searchHotelMB = new SearchHotelMB();
            searchHotelMB.setDestinationName(destinationName);
            searchHotelMB.setMinTripStartDate(minTripStartDate);
            searchHotelMB.setMaxTripStartDate(maxTripStartDate);
            searchHotelMB.setLengthOfStay(lengthOfStay);
            searchHotelMB.setMinStarRating(minStarRating);
            searchHotelMB.doSearch();
            OffersResults offersResults =searchHotelMB.getOffersResults();
            
            List<Hotel> hotelList= offersResults.getOffers().getHotelList();
            
            request.setAttribute("hotelList", hotelList);
            
            //Set the Entered Values by the User
            request.setAttribute("destinationName", destinationName);
            request.setAttribute("minTripStartDate", minTripStartDate);
            request.setAttribute("maxTripStartDate", maxTripStartDate);
            request.setAttribute("lengthOfStay", request.getParameter("lengthOfStay"));
            request.setAttribute("minStarRating", minStarRating);
            
            RequestDispatcher view = request.getRequestDispatcher("/HotelSearch.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
            doPost(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}