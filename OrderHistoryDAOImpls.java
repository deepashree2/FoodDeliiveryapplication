package com.foodDeliveryApp.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDeliveryApp.dao.OrderHistoryDAO;
import com.foodDeliveryApp.models.OrderHistory;
import com.foodDeliveryApp.models.User;

public class OrderHistoryDAOImpls implements OrderHistoryDAO{
	
	private static Connection connection = null;
	private static PreparedStatement prepareStatement = null;
	private static Statement statement = null;
	private static ResultSet res = null;
	
	
	private static final String INSERT_QUERY = "INSERT INTO OrderHistory(OrderHistoryId,UserID,OrderID,TotalAmout,Status) VALUES (?,?,?,?,?)";
	private static final String SELECT_QUERY = "SELECT * FROM OrderHistory where OrderHistoryId = ?";
	private static final String UPDATE_QUERY = "UPDATE OrderHistory SET  UserID = ? , OrderID = ?, TotalAmout = ?, Status   = ?WHERE OrderHistoryId= ? ";
	private static final String DELETE_QUERY = "DELETE FROM `OrderHistory' WHERE `OrderHistoryId` = ?";
	private static final String SELECT_ALL_QUERY ="SELECT * FROM `OrderHistory`";
	
	public OrderHistoryDAOImpls()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryApp", "root", "Xworkzodc@123");
		}
		catch (Exception e1) {
			e1.printStackTrace();
		} 
	}

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		
		try {
			
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, orderHistory.getOrderHistoryId());
			prepareStatement.setInt(2, orderHistory.getUserId());
			prepareStatement.setInt(3, orderHistory.getOrderId());
			prepareStatement.setInt(4, orderHistory.getTotalAmount());
			prepareStatement.setString(5,orderHistory.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int orderItemId) {
		

		try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, orderItemId);
			res = prepareStatement.executeQuery();
			
			if(res.next())
			{
				int OrderHistoryId1 = res.getInt("OrderHistoryId");
				int UserID = res.getInt("UserID");
				int OrderID = res.getInt("OrderID");
				int TotalAmout = res.getInt("TotalAmout");
				String Status = res.getString("Status");
				
				
				return new OrderHistory(OrderHistoryId1, UserID, OrderID, TotalAmout, Status);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateOrderItem(OrderHistory orderHistory) {
		
		//"UPDATE OrderHistory SET  UserID = ? , OrderID = ?, TotalAmout = ?, Status   = ?WHERE OrderHistoryId= ? ";
try {
			
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			
			prepareStatement.setInt(1, orderHistory.getUserId());
			prepareStatement.setInt(2, orderHistory.getOrderId());
			prepareStatement.setInt(3, orderHistory.getTotalAmount());
			prepareStatement.setString(4, orderHistory.getStatus());
			prepareStatement.setInt(4, orderHistory.getOrderHistoryId());
			
			
			
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderItemId) {
		
		try {
			
			prepareStatement =connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, orderItemId);
			prepareStatement.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderHistory> getAllOrderItem() {
		
		ArrayList<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
		
		try {
				statement = connection.createStatement();
				res = statement.executeQuery(SELECT_ALL_QUERY);
				
				while(res.next())
				{
					int OrderHistoryId1 = res.getInt("OrderHistoryId");
					int UserID = res.getInt("UserID");
					int OrderID = res.getInt("OrderID");
					int TotalAmout = res.getInt("TotalAmout");
					String Status = res.getString("Status");;
					
					OrderHistory oH = new OrderHistory(OrderHistoryId1, UserID, OrderID, TotalAmout, Status);
					orderHistory.add(oH);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return orderHistory;
	}
	

}
