package com.foodDeliveryApp.models;

public class Menu {
	
	private	int MenuID;
	private	int RestaurantID;
	private	String ItemName;
	private	String Description;
	private	double Price;
	private	boolean IsAvailable;
	private	double Ratings;
	private	String ImagePath;
	
	
	
	public Menu()
	{
		
	}



	public Menu(int menuID, int restaurantID, String itemName, String description, double price, boolean isAvailable,
			double ratings, String imagePath) {
		super();
		MenuID = menuID;
		RestaurantID = restaurantID;
		ItemName = itemName;
		Description = description;
		Price = price;
		IsAvailable = isAvailable;
		Ratings = ratings;
		ImagePath = imagePath;
	}



	public int getMenuID() {
		return MenuID;
	}



	public int getRestaurantID() {
		return RestaurantID;
	}



	public String getItemName() {
		return ItemName;
	}



	public String getDescription() {
		return Description;
	}



	public double getPrice() {
		return Price;
	}



	public boolean isIsAvailable() {
		return IsAvailable;
	}



	public double getRatings() {
		return Ratings;
	}



	public String getImagePath() {
		return ImagePath;
	}



	public void setMenuID(int menuID) {
		MenuID = menuID;
	}



	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}



	public void setItemName(String itemName) {
		ItemName = itemName;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public void setPrice(double price) {
		Price = price;
	}



	public void setIsAvailable(boolean isAvailable) {
		IsAvailable = isAvailable;
	}



	public void setRatings(double ratings) {
		Ratings = ratings;
	}



	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}



	@Override
	public String toString() {
		return "Menu [MenuID=" + MenuID + ", RestaurantID=" + RestaurantID + ", ItemName=" + ItemName + ", Description="
				+ Description + ", Price=" + Price + ", IsAvailable=" + IsAvailable + ", Ratings=" + Ratings
				+ ", ImagePath=" + ImagePath + "]";
	}
	
	
	

}
