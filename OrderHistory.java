package com.foodDeliveryApp.models;

public class OrderHistory {
	
	private int orderHistoryId;
	private int userId;
	private int orderId;
	private int totalAmount;
	private String status;

	
	public OrderHistory()
	{
		
	}


	public OrderHistory(int orderHistoryId, int userId, int orderId, int totalAmount, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.status = status;
	}


	public int getOrderHistoryId() {
		return orderHistoryId;
	}


	public int getUserId() {
		return userId;
	}


	public int getOrderId() {
		return orderId;
	}


	public int getTotalAmount() {
		return totalAmount;
	}


	public String getStatus() {
		return status;
	}


	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", userId=" + userId + ", orderId=" + orderId
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}



	
	
	
}
