package com.foodDeliveryApp.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDeliveryApp.dao.OrderItemDAO;
import com.foodDeliveryApp.models.OrderItem;
import com.foodDeliveryApp.models.User;

public class OrderItemDAOImpls implements OrderItemDAO{
	
	private static Connection connection = null;
	private static PreparedStatement prepareStatement = null;
	private static Statement statement = null;
	private static ResultSet res = null;
	
	
	private static final String INSERT_QUERY = "INSERT INTO OrderItem(OrderItemID,OrderID,MenuID,Quantity,ItemTotal) VALUES (?,?,?,?,?)";
	private static final String SELECT_QUERY = "SELECT * FROM OrderItem where OrderItemID = ?";
	private static final String UPDATE_QUERY = "UPDATE OrderItem SET  OrderID = ? , MenuID = ?, Quantity = ?, ItemTotal   = ? WHERE OrderItemID= ? ";
	private static final String DELETE_QUERY = "DELETE FROM OrderItem WHERE OrderItemID = ?";
	private static final String SELECT_ALL_QUERY ="SELECT * FROM OrderItem";
	
	
	
	public OrderItemDAOImpls()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryApp","root", "Xworkzodc@123");
		}
		catch (Exception e1) {
			e1.printStackTrace();
		} 
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		
		try {
			
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, orderItem.getOrderItemId());
			prepareStatement.setInt(2, orderItem.getOrderId());
			prepareStatement.setInt(3, orderItem.getMenuId());
			prepareStatement.setInt(4, orderItem.getQuantity());
			prepareStatement.setInt(5, orderItem.getItemTotal());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		
		try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, orderItemId);
			res = prepareStatement.executeQuery();
			
			if(res.next())
			{
				int orderItemId1 = res.getInt("OrderItemID");
				int orderId = res.getInt("OrderID");
				int menuId = res.getInt("MenuID");
				int quantity = res.getInt("Quantity");
				int totalPrice = res.getInt("ItemTotal");
				
				
				return new OrderItem(orderItemId1, orderId, menuId, quantity, totalPrice);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
	
try {
			
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			
			prepareStatement.setInt(1, orderItem.getOrderId());
			prepareStatement.setInt(2, orderItem.getMenuId());
			prepareStatement.setInt(3, orderItem.getQuantity());
			prepareStatement.setInt(4, orderItem.getItemTotal());
			prepareStatement.setInt(6, orderItem.getOrderItemId());
			
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		
		try {
			
			prepareStatement =connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, orderItemId);
			prepareStatement.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		
		ArrayList<OrderItem> orderItem = new ArrayList<OrderItem>();
		
		try {
				statement = connection.createStatement();
				res = statement.executeQuery(SELECT_ALL_QUERY);
				
				while(res.next())
				{
					int orderItemId1 = res.getInt("OrderItemID");
					int orderId = res.getInt("OrderID");
					int menuId = res.getInt("MenuID");
					int quantity = res.getInt("Quantity");
					int totalPrice = res.getInt("ItemTotal");
					
					OrderItem oI = new OrderItem(orderItemId1, orderId, menuId, quantity, totalPrice) ;
					orderItem.add(oI);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return orderItem;
	}
	
	
	

}
