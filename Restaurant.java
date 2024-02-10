package com.foodDeliveryApp.models;

public class Restaurant {
	
	private int RestaurantID;
	private String Name;
	private String CuisineType;
	private String Address;
	private int AdminUserID;
	private double Rating;
	private boolean IsActive;
	private String ImagePath;
	
	
	
	
	public Restaurant()
	{
		
	}


	public Restaurant(int restaurantID, String name, String cuisineType, String address, int adminUserID, double rating,
			boolean isActive, String imagePath) {
		super();
		RestaurantID = restaurantID;
		Name = name;
		CuisineType = cuisineType;
		Address = address;
		AdminUserID = adminUserID;
		Rating = rating;
		IsActive = isActive;
		ImagePath = imagePath;
	}


	public int getRestaurantID() {
		return RestaurantID;
	}


	public String getName() {
		return Name;
	}


	public String getCuisineType() {
		return CuisineType;
	}


	public String getAddress() {
		return Address;
	}


	public int getAdminUserID() {
		return AdminUserID;
	}


	public double getRating() {
		return Rating;
	}


	public boolean isIsActive() {
		return IsActive;
	}


	public String getImagePath() {
		return ImagePath;
	}


	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}


	public void setName(String name) {
		Name = name;
	}


	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public void setAdminUserID(int adminUserID) {
		AdminUserID = adminUserID;
	}


	public void setRating(double d) {
		Rating = d;
	}


	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}


	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	
	
	
	
}