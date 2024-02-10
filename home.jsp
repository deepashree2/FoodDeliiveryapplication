<%@page import="org.apache.tomcat.dbcp.dbcp2.DriverConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.foodDeliveryApp.models.Restaurant, com.foodDeliveryApp.daoImpls.RestaurantDAOImpls, com.foodDeliveryApp.util.DBConnectionUtil" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.List, com.foodDeliveryApp.models.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Restaurants</title>
    <link rel="stylesheet" href="rest.css">
</head>
<body>
<div style=" background-color:  #ff6600;"class="menu">
        <h1 >Hello, Welcome Restaurants </h1>
       
        <ul>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="SignUp.jsp">SignUp</a></li>
        </ul>
    </div>

    <div class="content">
        <!-- Content for Home -->
        <section id="login">
            <!-- Your home section content goes here -->
        </section>

        <!-- Content for Signup -->
        <section id="signup">
            <!-- Your signup section content goes here -->
        </section>
    </div>
    <h1 class="heading">Trending Restaurants</h1>
	<div class="restaurants-containner">
    	<% 
    	List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurantsList");
    	int count = 0;
    	for (Restaurant restaurant : restaurants) { 
    	%>
    	
    		<div class="restaurant-box">
    			<img src="<%= restaurant.getImagePath() %>" alt="none" >
        		<h3><%= restaurant.getName() %></h3>
       			<p style="color: #424769"><%=restaurant.getAddress() %></p>
				<p><span class="rating">Rating: <%=restaurant.getRating() %></span> <span "Cusine">Cusine Type: <%=restaurant.getCuisineType() %></span></p>
				<p><a href="RestaurantMenuServlet?restaurantID=<%=restaurant.getRestaurantID()%>"><button class="open-btn">Open</button></a></p>    
       		</div>
       		
       		
    		<%  
   		    count++;
    		if(count % 3 == 0)
   	 		{%>
    
   					 <div class="clearfix"></div>
   					 <%  
   		 } 
    }
    %>
    </div>
</body>
</html>