<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.foodDeliveryApp.models.Cart,java.util.Map,com.foodDeliveryApp.models.CartItem" %> 
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Shopping Cart</title>
<link rel="stylesheet" href="Addcart.css"> 

</head>
<body>
	<h1>Your Shopping Cart</h1>
	<div class="cart-items">
	
	<%
		//HttpSession  session = request.getSession();
			
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart != null && !cart.getItems().isEmpty()){
				for(CartItem item : cart.getItems().values())
				{
		%>
			<div class="cart-item">
				<h3><%=item.getName() %></h3>
				<p>
					&#8377;
					<%= item.getPrice() %></p>
				<form action="cart" method="post">
					<input type="hidden" name="itemID" value="<%=item.getItemID()%>">
					
					
					<label>Quantity: <input type="number" name="quantity"
					value="<%=item.getQuantity()%>" min="1"></label>
					
					
					<input type="submit" name="action" value="update"
					class="updtae-btn">
					
					
					<input type="submit" name="action"
					value="remove" class="remove-btn">
				
				</form>
			
			</div>
			<% 
		}
	}else {
	%>
	<p>Your cart is empty.</p>
	
	<%
	}
	%>
	
	<%--Add More Items Button --%>
	<a href="RestaurantMenuServlet?restaurantID=<%=session.getAttribute("restaurantID")%>" class="btn add-more-items-btn">
	Add More Items</a>
	
	<%-- Proceed to Checkout Button --%>
	<%
	if(session.getAttribute("cart") != null){
	%>
	
		<form action="checkout.jsp" method="post">
			<input type="submit" value="Proceed to Checkout" 
				class="btn proceed-to-checkout-btn">
		</form>
	
	<%
	}
	%>
	
	</div>


</body>
</html>
