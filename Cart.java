package com.foodDeliveryApp.models;

import java.util.HashMap;
import java.util.Map;

public  class Cart{
	
	private Map<Integer, CartItem> items;
	
	public Cart()
	{
		this.items = new  HashMap<>();
	}
	
	public void addItem(CartItem newitem) {
		//Add item to the cart
		int itemId = newitem.getItemID();
		if(items.containsKey(itemId)) {
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity() + newitem.getQuantity());
		}else {
			// If item is new, add to cart
			items.put(itemId, newitem);
		}	
	 }
	
	public void updateItme(int itemID,int quantity) {
		
		if(items.containsKey(itemID)) {
			if(quantity <= 0) {
				items.remove(itemID);
			}else {
				items.get(itemID).setQuantity(quantity);
			}
		}
		
	}
	
	
	//Remove an item from the cart
	public void removeItem(int itemID) {
		
		items.remove(itemID);
		
	}
	
	
	//Get all items in the cart
	public Map<Integer, CartItem> getItems()
	{
		return items;
		
	}
	
	//clear the cart
	void clear()
	{
		items.clear();
	}
}