package com.ty.food_app_hibernate_controller;

import com.ty.food_app_hibernate_dao.FoodOrderDao;

public class GetFoodOrderById {

	public static void main(String[] args) {
		
		FoodOrderDao fod=new FoodOrderDao();
		
		fod.getFoodOrderById(1);
	}
}
