package com.foodDeliveryApp.models;

public class CartItem {
	
	private  int itemID;
	private int restaurantID;
	private String name;
	private int quantity;
	private double price;
	
	public CartItem()
	{
		
	}

	public CartItem(int itemID, int restaurantID, String name, int quantity, double price) {
		super();
		this.itemID = itemID;
		this.restaurantID = restaurantID;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemID() {
		return itemID;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [itemID=" + itemID + ", restaurantID=" + restaurantID + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
}
