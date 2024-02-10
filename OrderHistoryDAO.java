package com.foodDeliveryApp.dao;

import java.util.List;

import com.foodDeliveryApp.models.OrderHistory;

public interface OrderHistoryDAO {
	
	void addOrderHistory(OrderHistory menu);
	OrderHistory getOrderHistory(int orderItemId);
	void updateOrderItem(OrderHistory menu);
	void deleteOrderHistory(int orderItemId);
	List<OrderHistory> getAllOrderItem();

}
