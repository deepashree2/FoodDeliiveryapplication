package com.foodDeliveryApp.dao;

import java.util.List;
import com.foodDeliveryApp.models.Menu;

public interface MenuDAO {
	
	void addMenu(Menu Menu);
	Menu getMenu(int MenuID);
	void updateMenu(Menu Menu);
	void deleteMenu(int MenuID);
	//List<Menu> getAllMenu();
	List<Menu> getAllMenu(int RestaurantID);

}
