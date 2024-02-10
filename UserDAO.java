package com.foodDeliveryApp.dao;

import java.util.List;
import com.foodDeliveryApp.models.User;

public interface UserDAO {
	
	void addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
	User getUserByUserame(String username);

}
