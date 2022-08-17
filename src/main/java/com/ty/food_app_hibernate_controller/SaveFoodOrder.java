package com.ty.food_app_hibernate_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.food_app_hibernate_dao.FoodMenuDao;
import com.ty.food_app_hibernate_dao.FoodOrderDao;
import com.ty.food_app_hibernate_dto.FoodMenu;
import com.ty.food_app_hibernate_dto.Item;

public class SaveFoodOrder {

	
	public static void main(String[] args) {
		
		FoodMenuDao fd=new FoodMenuDao();
		
		FoodMenu foodMenu=fd.getFoodMenuById(2);
		
		Item i=new Item();
		i.setName(foodMenu.getName());
		i.setCost(foodMenu.getCost());
		i.setQty(2);
		
FoodMenu foodMenu1=fd.getFoodMenuById(1);
		
		Item i1=new Item();
		i1.setName(foodMenu1.getName());
		i1.setCost(foodMenu1.getCost());
		i1.setQty(3);
		
		List<Item> items=new ArrayList<Item>();
		
		items.add(i);
		items.add(i1);
		
		
		FoodOrderDao fod=new FoodOrderDao();
		
		fod.SaveFoodOrder(items);
		
		
	}
}
