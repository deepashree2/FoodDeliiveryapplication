package com.foodDeliveryApp.servletss;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodDeliveryApp.dao.OrderTableDAO;
import com.foodDeliveryApp.daoImpls.OrderTableDAOImpls;
import com.foodDeliveryApp.models.Cart;
import com.foodDeliveryApp.models.CartItem;
import com.foodDeliveryApp.models.OrderTable;
import com.foodDeliveryApp.models.User;


@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private OrderTableDAO orderDAO;
	
	@Override
	public void init() {
		orderDAO = new OrderTableDAOImpls();
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("loggedInUser");
		
		
		if(cart != null &&  !cart.getItems().isEmpty()) {
			// Extract checkout form data
			String paymentMethod = request.getParameter("paymentMethod");
			
			//Create and populate the order object
			
			OrderTable OrderTable = new OrderTable();
			
			OrderTable.setUserID(user.getUserId());
			System.out.println(session.getAttribute("restaurantID"));
			OrderTable.setRestaurantID((int) session.getAttribute("restaurantID"));
			//OrderTable.setOrderDate(new Date());
			OrderTable.setPaymentMethod(paymentMethod);
			OrderTable.setStatus("Pending");
			
			
			// Add cart items to the order and calculate the total amount
			double totalAmout = 0;
			for(CartItem item : cart.getItems().values()) {
				totalAmout += item.getPrice()* item.getQuantity();
			}
			
			OrderTable.setTotalAmount(totalAmout);
			
			// Save the  order to the database
			orderDAO.addOrder(OrderTable);
			
			//Clear the cart and redirect to the order confirmation page
			
			session.removeAttribute("cart");
			session.setAttribute("order", OrderTable);
			response.sendRedirect("order_confirmation.jsp");
					
		}else {
			response.sendRedirect("cart.jsp");//Redirect to cart if it's empty or user no login
		}
		}
}