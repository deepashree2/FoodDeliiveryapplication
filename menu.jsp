<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, com.foodDeliveryApp.models.Menu, com.foodDeliveryApp.util.DBConnectionUtil" %>
    <%@ page import="java.sql.*" %>
	<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
  <link rel="stylesheet" href="menu.css">
</head>
<body>

<nav class="menu-bar">
    <ul>
        <h3 class="menu-title" style="margin-left: 47%;">Menus</h3>
    </ul>
</nav>
  
<h1 class="heading" style="margin-left: 40%;">Restaurant Menu</h1>  
   
<div class="menu-container">
    <%
    List<Menu> menuItems = (List<Menu>)request.getAttribute("menuList");
    if(menuItems != null){
    for(Menu item: menuItems){
    %>
    <div class="menu-item">
        <img src="<%= item.getImagePath()%>" alt="none">
        <h3><%=item.getItemName() %></h3>
        <p><%=item.getDescription() %></p>
        <P>Price:&#8377; <%= item.getPrice() %></P>
        <p>Rating: <%=item.getRatings() %></p>
        
        <form action="cart" method="post">
            Quantity: <input type="number" name="quantity" value="1" min="1"
            class="quantity-input">
            
            <input type="submit" value="Add to Cart" class="add-to-cart-btn">
            <input type="hidden" name="itemID" value="<%=item.getMenuID()%>">
            <input type="hidden" name="action" value="add">
        </form>
    </div>

   
        <div class="clearfix"></div>
    <% 
    	
    }
    } else{%>
    <p>No menus Available</p>
    <%} %>
</div>
  
</body>
</html>