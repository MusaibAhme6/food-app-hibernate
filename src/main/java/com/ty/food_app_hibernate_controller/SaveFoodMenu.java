package com.ty.food_app_hibernate_controller;

import com.ty.food_app_hibernate_dao.FoodMenuDao;
import com.ty.food_app_hibernate_dto.FoodMenu;

public class SaveFoodMenu {

	public static void main(String[] args) {
		
		
		FoodMenu foodMenu=new FoodMenu();
		
		foodMenu.setName("Chicken Charger");
		foodMenu.setDescription("Chicken charger ");
		foodMenu.setCost(150.0);
		
		FoodMenuDao fd=new FoodMenuDao();
		
		fd.SaveFoodMenu(foodMenu);
	}
}
