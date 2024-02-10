package com.foodDeliveryApp.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDeliveryApp.dao.RestaurantDAO;
import com.foodDeliveryApp.models.Restaurant;
import com.foodDeliveryApp.util.DBConnectionUtil;

public class RestaurantDAOImpls implements RestaurantDAO {
	
	private static Connection connection;
	private static PreparedStatement prepareStatement ;
	private static Statement statement;
	private static ResultSet res ;
	
	private static final String INSERT_QUERY = "INSERT INTO restaurant(RestaurantID, Name, CuisineType, Address, AdminUserID, Rating, IsActive, ImagePath)"
			+ "VALUES (?,?,?,?,?,?,?,?')";
	private static final String SELECT_QUERY = "SELECT * FROM restaurant where RestaurantID = ?";
	private static final String UPDATE_QUERY = "UPDATE restaurant SET  name = ? , CuisineType = ?, Address = ?,AdminUserID =?, Rating = ?, IsActive = ?, ImagePath = ? WHERE  RestaurantID= ?";
	private static final String DELETE_QUERY = "DELETE FROM  restaurant WHERE RestaurantID = ?";
	private static final String SELECT_ALL_QUERY ="SELECT * from Restaurant";
	
	public RestaurantDAOImpls(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryApp", "root", "Xworkzodc@123");
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public void addRestaurant(Restaurant Restaurant) {
		
		try {
			
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, Restaurant.getRestaurantID());
			prepareStatement.setString(2, Restaurant.getName());
			prepareStatement.setString(3, Restaurant.getCuisineType());
			prepareStatement.setString(4, Restaurant.getAddress());
			prepareStatement.setInt(5, Restaurant.getAdminUserID());
			prepareStatement.setDouble(6, Restaurant.getRating());
			prepareStatement.setBoolean(7, Restaurant.isIsActive());
			prepareStatement.setString(8, Restaurant.getImagePath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int RestaurantID) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, RestaurantID);
			res = prepareStatement.executeQuery();
			
			if(res.next()) {
				Restaurant Restaurant = new Restaurant();
				Restaurant.setRestaurantID(res.getInt("RestaurantID"));
				Restaurant.setName(res.getString("Name"));
				Restaurant.setCuisineType(res.getString("CuisineType"));
				Restaurant.setAddress(res.getString("Address"));
				Restaurant.setAdminUserID(res.getInt("AdminUserID"));
				Restaurant.setRating(res.getInt("Rating"));
				Restaurant.setIsActive(res.getBoolean("IsActive"));
				Restaurant.setImagePath(res.getString("ImagePath"));
				
				return Restaurant;
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateRestaurant(Restaurant Restaurant) {
		
		try {
			
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			
			prepareStatement.setString(1, Restaurant.getName());
			prepareStatement.setString(2, Restaurant.getCuisineType());
			prepareStatement.setString(3, Restaurant.getAddress());
			prepareStatement.setInt(4, Restaurant.getAdminUserID());
			prepareStatement.setDouble(5, Restaurant.getRating());
			prepareStatement.setBoolean(6, Restaurant.isIsActive());
			prepareStatement.setString(7, Restaurant.getImagePath());
			prepareStatement.setInt(8, Restaurant.getRestaurantID());
			
			prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int RestaurantID) {
		
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, RestaurantID);
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                
                
                int rId = resultSet.getInt("RestaurantID");
                String rName = resultSet.getString("Name");
                String rCusine = resultSet.getString("CuisineType");
                String rAddress =  resultSet.getString("Address");
                int rId1 = resultSet.getInt("AdminUserID");
                double rRating = resultSet.getDouble("Rating");
                boolean rIsActive = resultSet.getBoolean("IsActive");
                String rImagePath = resultSet.getString("ImagePath");
                
                Restaurant restaurant = new Restaurant(rId, rName, rCusine, rAddress, rId1, rRating, rIsActive, rImagePath);

                
                restaurants.add(restaurant);
                
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }





}
