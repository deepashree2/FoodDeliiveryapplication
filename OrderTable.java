package com.foodDeliveryApp.models;

import java.sql.Date;

public class OrderTable {
	
	private	int OrderID;
	private	int UserID;
	private	int RestaurantID;
	private Date OrderDate;
	private	double TotalAmount;
	private	String Status;
	private	String PaymentMethod;
	
	public OrderTable()
	{
		
	}
	
	public int getOrderID() {
		return OrderID;
	}

	public int getUserID() {
		return UserID;
	}

	public int getRestaurantID() {
		return RestaurantID;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public String getStatus() {
		return Status;
	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public void setRestaurantID(int date) {
		RestaurantID = date;
	}

	public void setOrderDate(Date date) {
		OrderDate = date;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}

	public OrderTable(int orderID, int userID, int restaurantID,Date orderDate, double totalAmount, String status,
			String paymentMethod) {
		super();
		OrderID = orderID;
		UserID = userID;
		RestaurantID = restaurantID;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		Status = status;
		PaymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "OrderTable [OrderID=" + OrderID + ", UserID=" + UserID + ", RestaurantID=" + RestaurantID
				+ ", OrderDate=" + OrderDate + ", TotalAmount=" + TotalAmount + ", Status=" + Status
				+ ", PaymentMethod=" + PaymentMethod + "]";
	}


	
	
	

	

}
