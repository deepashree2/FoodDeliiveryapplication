package com.foodDeliveryApp.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDeliveryApp.dao.OrderTableDAO;
import com.foodDeliveryApp.models.Menu;
import com.foodDeliveryApp.models.OrderTable;
import com.foodDeliveryApp.models.Restaurant;
import com.foodDeliveryApp.models.User;
import com.foodDeliveryApp.util.DBConnectionUtil;

public class OrderTableDAOImpls implements OrderTableDAO{
	
	private static Connection connection ;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;
	
	
	private static final String INSERT_QUERY = "INSERT INTO OrderTable(OrderID,UserID,RestaurantID,OrderDate,TotalAmount,Status,PaymentMethod) VALUES (?,?,?,?,?,?,?);";
	private static final String SELECT_QUERY = "SELECT * FROM OrderTable where OrderID = ?";
	private static final String UPDATE_QUERY = "UPDATE OrderTable SET UserID = ?, RestaurantID = ?, OrderDate   = ?, TotalAmount = ?, Status=?, PaymentMethod = ? WHERE OrderID = ?";
	private static final String DELETE_QUERY = "DELETE FROM OrderTable WHERE OrderID = ?";
	private static final String SELECT_ALL_QUERY ="SELECT * FROM OrderTable WHERE UserID = ?";
	
	public OrderTableDAOImpls()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryApp","root", "Xworkzodc@123");
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void addOrder(OrderTable order) {
		
		try {
			
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setInt(1, order.getOrderID());
			prepareStatement.setInt(2, order.getUserID());
			prepareStatement.setInt(3, order.getOrderID());
			prepareStatement.setDate(4, order.getOrderDate());
			prepareStatement.setDouble(5, order.getTotalAmount());
			prepareStatement.setString(6, order.getStatus());
			prepareStatement.setString(7, order.getPaymentMethod());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public OrderTable getOrder(int OrderID) {
		try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, OrderID);
			res = prepareStatement.executeQuery();
			
			if(res.next())
			{
				OrderTable OrderTable = new OrderTable();
				OrderTable.setOrderID(res.getInt("OrderID"));
				OrderTable.setUserID(res.getInt("UserID"));
				OrderTable.setRestaurantID(res.getInt("RestaurantID"));
				OrderTable.setOrderDate(res.getDate("OrderDate"));
				OrderTable.setTotalAmount(res.getDouble("TotalAmount"));
				OrderTable.setStatus(res.getString("Status"));
				OrderTable.setPaymentMethod(res.getString("PaymentMethod"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	@Override
	public void updateOrder(OrderTable Order) {
		
		
		try {
			
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setInt(1, Order.getUserID());
			prepareStatement.setInt(2, Order.getRestaurantID());
			prepareStatement.setDate(3, Order.getOrderDate());
			prepareStatement.setDouble(4, Order.getTotalAmount());
			prepareStatement.setString(5, Order.getStatus());
			prepareStatement.setString(6, Order.getPaymentMethod());
			prepareStatement.setInt(7, Order.getOrderID());
			
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public void deleteOrder(int OrderID) {
		
		try {
			
			prepareStatement =connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, OrderID);
			prepareStatement.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<OrderTable> getAllOrdersByUser(int RestaurantID) {
		ArrayList<OrderTable> menus = new ArrayList<>();
		
		try {
			prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			prepareStatement.setInt(1, RestaurantID);
			res=prepareStatement.executeQuery();
			
			while(res.next())
			{
				OrderTable OrderTable = new OrderTable();
				OrderTable.setOrderID(res.getInt("OrderID"));
				OrderTable.setUserID(res.getInt("UserID"));
				OrderTable.setRestaurantID(res.getInt("RestaurantID"));
				OrderTable.setOrderDate(res.getDate("OrderDate"));
				OrderTable.setTotalAmount(res.getDouble("TotalAmount"));
				OrderTable.setStatus(res.getString("Status"));
				OrderTable.setPaymentMethod(res.getString("PaymentMethod"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
