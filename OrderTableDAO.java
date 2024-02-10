package com.foodDeliveryApp.dao;

import java.util.List;

import com.foodDeliveryApp.models.OrderTable;


public interface OrderTableDAO {
	
	void addOrder(OrderTable menu);
	OrderTable getOrder(int orderId);
	void updateOrder(OrderTable menu);
	void deleteOrder(int orderId);
	List<OrderTable> getAllOrdersByUser(int UserID);

}
