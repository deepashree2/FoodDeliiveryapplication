package com.foodDeliveryApp.servletss;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDeliveryApp.dao.MenuDAO;
import com.foodDeliveryApp.daoImpls.MenuDAOImpls;
import com.foodDeliveryApp.daoImpls.RestaurantDAOImpls;
import com.foodDeliveryApp.models.Menu;


@WebServlet("/RestaurantMenuServlet")
public class RestaurantMenuServlet extends HttpServlet {
private MenuDAO menuDAO ;
	
	@Override 
	public void init() {
		menuDAO = new MenuDAOImpls();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

        String restaurantID = req.getParameter("restaurantID");
        
       try {
    	   List<Menu> menus =  menuDAO.getAllMenu(Integer.parseInt(restaurantID));
    	   req.setAttribute("menuList", menus);
       }catch(NumberFormatException e) {
    	   
       }
        
       
        RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
        rd.forward(req, resp);
        
    }
}
