package com.foodDeliveryApp.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDeliveryApp.dao.MenuDAO;
import com.foodDeliveryApp.models.Menu;
import com.foodDeliveryApp.models.Restaurant;
import com.foodDeliveryApp.models.User;
import com.foodDeliveryApp.util.DBConnectionUtil;

public class MenuDAOImpls implements MenuDAO{
	
	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;
	
	
	private static final String INSERT_QUERY = "INSERT INTO Menu (MenuID,RestaurantID, ItemName, Description, Price, IsAvailable, Ratings, ImagePath)VALUES (?, ?, ?, ?, ?,?, ?,?)";
	private static final String SELECT_QUERY = "SELECT * FROM Menu where MenuID = ?";
	private static final String UPDATE_QUERY = "UPDATE Menu SET  RestaurantID = ? , ItemName = ?, Description =?, Price = ?, IsAvailable = ?, Ratings =?, ImagePath=? WHERE MenuID=?";
	private static final String DELETE_QUERY = "DELETE FROM Menu  WHERE MenuID = ?";
	private static final String SELECT_ALL_QUERY ="SELECT * FROM Menu where RestaurantID = ?";
	
	public MenuDAOImpls(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryApp", "root", "Xworkzodc@123");
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public void addMenu(Menu Menu) {
		
		try {
			
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, Menu.getMenuID());
			prepareStatement.setInt(2, Menu.getRestaurantID());
			prepareStatement.setString(3, Menu.getItemName());
			prepareStatement.setString(4, Menu.getDescription());
			prepareStatement.setDouble(5, Menu.getPrice());
			prepareStatement.setBoolean(6,Menu.isIsAvailable());
			prepareStatement.setDouble(7, Menu.getRatings());
			prepareStatement.setString(8, Menu.getImagePath());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public Menu getMenu(int MenuID) {
		
		try {
			
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, MenuID);
			res = prepareStatement.executeQuery();
			
			if(res.next())
			{
				Menu Menu = new Menu();
				Menu.setMenuID(res.getInt("MenuId"));
				Menu.setRestaurantID(res.getInt("RestaurantID"));
				Menu.setItemName(res.getString("ItemName"));
				Menu.setDescription(res.getString("Description"));
				Menu.setPrice(res.getDouble("Price"));
				Menu.setIsAvailable(res.getBoolean("IsAvailable"));
				Menu.setRatings(res.getDouble("Ratings"));
				Menu.setImagePath(res.getString("ImagePath"));
				
				
				return Menu;//MenuId,RestaurantID,ItemName,Description,Price,IsAvailable,Ratings,ImagePath
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public void updateMenu(Menu Menu) {
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			
			prepareStatement.setInt(1, Menu.getRestaurantID());
			prepareStatement.setString(2, Menu.getItemName());
			prepareStatement.setString(3, Menu.getDescription());
			prepareStatement.setDouble(4, Menu.getPrice());
			prepareStatement.setBoolean(5, Menu.isIsAvailable());
			prepareStatement.setDouble(6, Menu.getRatings());
			prepareStatement.setString(7, Menu.getImagePath());
			prepareStatement.setInt(8, Menu.getMenuID());
			
			
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void deleteMenu(int MenuID) {
		try {
			
			prepareStatement =connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, MenuID);
			prepareStatement.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	@Override
	public List<Menu> getAllMenu(int RestaurantID) {
		
		ArrayList<Menu> menus = new ArrayList<>();
		
		try {
			prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			prepareStatement.setInt(1, RestaurantID);
			res=prepareStatement.executeQuery();
			
			while(res.next())
			{
				Menu Menu = new Menu();
				Menu.setMenuID(res.getInt("MenuID"));
				Menu.setRestaurantID(res.getInt("RestaurantID"));
				Menu.setItemName(res.getString("ItemName"));
				Menu.setDescription(res.getString("Description"));
				Menu.setPrice(res.getDouble("Price"));
				Menu.setIsAvailable(res.getBoolean("IsAvailable"));
				Menu.setRatings(res.getDouble("Ratings"));
				Menu.setImagePath(res.getString("ImagePath"));
				
				menus.add(Menu);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
      return menus;
  }
	
	

}
