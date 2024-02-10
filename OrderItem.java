package com.foodDeliveryApp.models;

public class OrderItem {
	
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private int itemTotal;
	
	public OrderItem()
	{
		
	}

	public OrderItem(int orderItemId, int orderId, int menuId, int quantity, int itemTotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItemTotal() {
		return itemTotal;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity="
				+ quantity + ", itemTotal=" + itemTotal + "]";
	}
	
	
	

}

