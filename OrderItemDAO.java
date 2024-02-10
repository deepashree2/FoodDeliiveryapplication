package com.foodDeliveryApp.dao;

import java.util.List;
import com.foodDeliveryApp.models.OrderItem;

public interface OrderItemDAO {
	
	void addOrderItem(OrderItem menu);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem menu);
	void deleteOrderItem(int orderItemId);
	List<OrderItem> getAllOrderItem();

}
