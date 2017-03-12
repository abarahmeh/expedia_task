<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.expedia.bean.offers.Hotel" %>
<%@ page import="com.expedia.bean.offers.hotel.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;"/>
    <title>Hotel Search</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script>
        $(function() {
            $( "#minTripStartDate" ).datepicker({dateFormat: 'yy-mm-dd'});
            $( "#maxTripStartDate" ).datepicker({dateFormat: 'yy-mm-dd'});
        });
    </script>
  </head>
  <body>
  <%
      String destinationName ="";
      String minTripStartDate="";
      String maxTripStartDate= "";
      String lengthOfStay = "";
      String minStarRating="";
      
      if (request.getAttribute("destinationName") != null) {
        destinationName = request.getAttribute("destinationName").toString();
      }
      if (request.getAttribute("minTripStartDate") != null) {
        minTripStartDate = request.getAttribute("minTripStartDate").toString();
      }
      if (request.getAttribute("maxTripStartDate") != null) {
        maxTripStartDate = request.getAttribute("maxTripStartDate").toString();
      }
      if (request.getAttribute("lengthOfStay") != null) {
        lengthOfStay = request.getAttribute("lengthOfStay").toString();
      }
      if (request.getAttribute("minStarRating") != null) {
        minStarRating = request.getAttribute("minStarRating").toString();
      }
  %>
    <form method="post" name="hotelSearchFrm" action="SearchHotel">
      <table border="0" bgcolor="white">
        <tr>
            <td colspan=2 style="font-size:14pt;color:teal;">
                <h3>Hotel Search</h3>
            </td>
        </tr>
        <tr>
            <td ><b>Destination Name:</b></td>
            <td><input type="text" name="destinationName" id="destinationName" title="Enter the destination Name" value="<%=destinationName%>" ></td>
        </tr>
        <tr>
            <td ><b>Min Trip Start Date:</b></td>
            <td><input type="text" name="minTripStartDate" id="minTripStartDate" title="Enter the Minimum Trip Start Date" value="<%=minTripStartDate%>" ></td>
        </tr>
        <tr>
            <td ><b>Max Trip Start Date:</b></td>
            <td><input type="text" name="maxTripStartDate" id="maxTripStartDate" title="Enter the Maximum Trip Start Date"  value="<%=maxTripStartDate%>" ></td>
        </tr>
        <tr>
            <td ><b>Length Of Stay:</b></td>
            <td><input type="text" name="lengthOfStay" id="lengthOfStay" title="Enter the Length Of Stay" value="<%=lengthOfStay%>" ></td>
        </tr>
        <tr>
            <td ><b>Min Star Rating:</b></td>
            <td><input type="text" name="minStarRating" id="minStarRating" title="Enter the Minimum Star Rating" value="<%=minStarRating%>" ></td>
        </tr>
        <tr>
            <td ><b>Sort By:</b></td>
            <td>
                <select name="sortBy" id="sortBy" title="Sort By">
                    <option value="TotalPriceValue">Total Price Value</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="submit" name="submit" value="Search">
            </td>
        </tr>
      </table>
    </form>
    <br><br>
    <table style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>Search Results</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>No</b></td>
                <td><b>Hotel Name</b></td>
                <td><b>Hotel Location</b></td>
                <td><b>Hotel Star Rating</b></td>
                <td><b>Travel Start Date</b></td>
                <td><b>Travel End Date</b></td>
                <td><b>Total Price Value</b></td>
                <td><b>Percent Savings</b></td>
                
            </tr>
            <%
                String color = "#F9EBB3";
                int count =0;
                if (request.getAttribute("hotelList") != null) {
                    ArrayList<Hotel> hotelList = (ArrayList<Hotel>) request.getAttribute("hotelList");
                    count = hotelList.size();
                    for (int i=0; i<count; i++) {
                        Hotel hotel = hotelList.get(i);
                        if ((i % 2) == 0) {
                            color = "#eeffee";
                        }else{
                            color = "#F9EBB3";
                        }
                        
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=i+1%></td>
                <td><%=hotel.getHotelInfo().getHotelName()%></td>
                <td><%=hotel.getDestination().getCity() + ", " + hotel.getDestination().getCountry()%></td>
                <td><%=hotel.getHotelInfo().getHotelStarRating()%></td>
                <td><%=hotel.getHotelInfo().getTravelStartDate()%></td>
                <td><%=hotel.getHotelInfo().getTravelEndDate()%></td>
                <td><%=hotel.getHotelPricingInfo().getTotalPriceValue()%></td>
                <td><%=hotel.getHotelPricingInfo().getPercentSavings()%></td>
                
            </tr>
            <%
                    }
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=8 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>
  </body>
</html>