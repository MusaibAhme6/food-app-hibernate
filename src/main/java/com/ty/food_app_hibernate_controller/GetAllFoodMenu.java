package com.ty.food_app_hibernate_controller;

import com.ty.food_app_hibernate_dao.FoodMenuDao;

public class GetAllFoodMenu {

	public static void main(String[] args) {
		
		FoodMenuDao fd=new FoodMenuDao();
		
		fd.getAllMenu();
	}
}
