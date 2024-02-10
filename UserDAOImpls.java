package com.foodDeliveryApp.daoImpls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDeliveryApp.dao.UserDAO;
import com.foodDeliveryApp.models.User;

public class UserDAOImpls implements UserDAO {

    private static Connection connection;
    private static PreparedStatement prepareStatement;
    private static Statement statement;
    private static ResultSet res;

    private static final String INSERT_QUERY = "INSERT INTO User(Username, Password, Email, Address, Role) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM User WHERE UserID = ?";
    private static final String UPDATE_QUERY = "UPDATE User SET Username = ?, Password = ?, Email = ?, Address = ?, Role = ? WHERE UserID = ?";
    private static final String DELETE_QUERY = "DELETE FROM User WHERE UserID = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM User";
    
    
  

public UserDAOImpls(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryApp", "root", "Xworkzodc@123");
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
		
		
	}

    @Override
    public void addUser(User user) {
        try {
            prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setString(1, user.getUserName());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getAddress());
            prepareStatement.setString(5, user.getRole());
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public User getUser(int userId) {
        try {
            prepareStatement = connection.prepareStatement(SELECT_QUERY);
            prepareStatement.setInt(1, userId);
            res = prepareStatement.executeQuery();

            if (res.next()) {
                int userId1 = res.getInt("UserID");
                String userName = res.getString("Username");
                String password = res.getString("Password");
                String email = res.getString("Email");
                String address = res.getString("Address");
                String role = res.getString("Role");
                
                return new User(userId1, userName, email, password, address, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        try {
            prepareStatement = connection.prepareStatement(UPDATE_QUERY);
            prepareStatement.setString(1, user.getUserName());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getAddress());
            prepareStatement.setString(5, user.getRole());
            prepareStatement.setInt(6, user.getUserId());
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            prepareStatement = connection.prepareStatement(DELETE_QUERY);
            prepareStatement.setInt(1, userId);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            res = statement.executeQuery(SELECT_ALL_QUERY);

            while (res.next()) {
                int userId1 = res.getInt("UserID");
                String userName = res.getString("Username");
                String password = res.getString("Password");
                String email = res.getString("Email");
                String address = res.getString("Address");
                String role = res.getString("Role");

                User user = new User(userId1, userName, email, password, address, role);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return users;
    }

    @Override
    public User getUserByUserame(String username) {
        try {
            prepareStatement = connection.prepareStatement("SELECT * FROM User WHERE Username = ?");
            prepareStatement.setString(1, username);
            res = prepareStatement.executeQuery();
            if (res.next()) {
                int userId = res.getInt("UserID");
                String userName = res.getString("Username");
                String password = res.getString("Password");
                String email = res.getString("Email");
                String address = res.getString("Address");
                String role = res.getString("Role");

                return new User(userId, userName, email, password, address, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    // Helper method to close resources
    private void closeResources() {
        try {
            if (res != null) {
                res.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
