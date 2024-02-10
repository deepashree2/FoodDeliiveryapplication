<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.foodDeliveryApp.models.OrderTable" %>
    <%@ page import="java.sql.*" %>
	<%@ page import="java.io.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
<link rel="stylesheet" href="orderconfirmation.css">
</head>
<body>
    <h1>Order Confirmation</h1>
    <div class="box">
        <%
        OrderTable order = (OrderTable) session.getAttribute("order");
        if (order != null) {
        %>  
        
        <div class="order-details">
            <p>Thank you for your order!</p>
            
            <p>Order ID: <%=order.getOrderID() %></p>
            
            <p>Total Amount: <%=order.getTotalAmount() %></p>
            
            <p>Status: <%= order.getStatus()  %></p>
            
            <p>Payment Method: <%=order.getPaymentMethod() %></p>
            
            <p style="color:blue;"><form action="home"><button>Return Home Page</button></form></p>
        </div>
        <%
        } else {
        %>
        <p>No order details available.</p>
        <%
        }
        %>
    </div>
</body>
</html>