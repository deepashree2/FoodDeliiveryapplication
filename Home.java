package com.foodDeliveryApp.servletss;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDeliveryApp.dao.RestaurantDAO;
import com.foodDeliveryApp.daoImpls.RestaurantDAOImpls;
import com.foodDeliveryApp.models.Restaurant;

@WebServlet("/home")
public class Home extends HttpServlet {
	
	private RestaurantDAO restaurantDAO ;
	
	@Override 
	public void init() {
		restaurantDAO = new RestaurantDAOImpls();
	}

	@Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	//Fecth list restaurants
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurant();

        //Set the restaurant list as request attribute
        req.setAttribute("restaurantsList", restaurants);
      
        

        RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
        dispatcher.include(req, resp);
    }
}



