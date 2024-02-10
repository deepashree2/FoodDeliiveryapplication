package com.foodDeliveryApp.dao;

import java.util.List;
import com.foodDeliveryApp.models.Restaurant;

public interface RestaurantDAO {
	
	void addRestaurant(Restaurant Restaurant);
	Restaurant getRestaurant(int RestaurantId);
	void updateRestaurant(Restaurant Restaurant);
	void deleteRestaurant(int RestaurantId);
	List<Restaurant> getAllRestaurant();

}
