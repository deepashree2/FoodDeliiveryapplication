package com.foodDeliveryApp.servletss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodDeliveryApp.dao.MenuDAO;
import com.foodDeliveryApp.daoImpls.MenuDAOImpls;
import com.foodDeliveryApp.models.Cart;
import com.foodDeliveryApp.models.CartItem;
import com.foodDeliveryApp.models.Menu;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");
		if(action.equals("add"))
		{
			addItemToCart(request, cart);
		} else if(action.equals("update"))
		{
			updateCartItem(request, cart);
		} else if(action.equals("remove")) {
			removeItemFromCart(request, cart);
		}
		
		
		session.setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cart.jsp").forward(request,response);
	}
	
	private void addItemToCart(HttpServletRequest request, Cart cart) {
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		MenuDAO menuDAO = new MenuDAOImpls();
		Menu menuItem = menuDAO.getMenu(itemID);
		
		HttpSession session = request.getSession();
		session.setAttribute("restaurantID", menuItem.getRestaurantID());
		
		if(menuItem != null) {
			
			CartItem item = new CartItem(
					menuItem.getMenuID(),
					menuItem.getRestaurantID(),
					menuItem.getItemName(),
					quantity,
					menuItem.getPrice()
					);
			cart.addItem(item);
		}
		
		
	}
	
	private void  updateCartItem(HttpServletRequest request, Cart cart) {
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItme(itemID, quantity);
	}
	
	
	private void removeItemFromCart(HttpServletRequest request, Cart cart) {
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		cart.removeItem(itemID);
	}

}
