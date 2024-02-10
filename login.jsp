<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.foodDeliveryApp.models.User" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.List, com.foodDeliveryApp.models.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles1.css">
    <!-- Add your stylesheets or other head elements here -->
</head>
<body>

   <!--  <div class="container">
        <form action="LoginServlet" method="post" class="login-form">
            Enter User Name: <input type="text" name="loggedInUser">
            <br>
            Enter Password: <input type="password" name="password">
            <br>
            <input type="submit" value="Login" class="login-btn">
        </form>
    </div> -->
    
    <form action="LoginServlet"  method="post">
            <h2>Login</h2>
            <div class="input-group">
                <label for="loggedInUser">Username</label>
                <input type="text"  name="loggedInUser" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" name="password" required>
            </div>
            
               
            <button type="submit" value="Login">Login</button>

    <!-- Display an error message if available -->
    <% String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.isEmpty()) { %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>

    <!-- Add any other content you want -->

</body>
</html>