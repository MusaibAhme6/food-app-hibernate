package com.ty.food_app_hibernate_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app_hibernate_dto.FoodMenu;

public class FoodMenuDao {

	
	public void SaveFoodMenu(FoodMenu foodmenu) {
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(foodmenu);
		entityTransaction.commit();
		
		System.out.println("Menu saved Successfully");
	}
	
	public List<FoodMenu> getAllMenu(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		String q="select f from FoodMenu f ";
		Query query=entityManager.createQuery(q);
		List<FoodMenu> fm=query.getResultList();
		
		for(FoodMenu f:fm) {
			System.out.println(f);
			
		}
		
		return fm;	
	}
	
	public FoodMenu getFoodMenuById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="select f from FoodMenu f where f.id=?1";
		Query query=entityManager.createQuery(q);
		query.setParameter(1, id);
		List<FoodMenu> fm=query.getResultList();
		
		FoodMenu foodMenu=fm.get(0);
		
			//System.out.println(foodMenu);
			
		return foodMenu;
		
	}
	
	public void UpdateFoodMenu(FoodMenu foodMenu,int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		FoodMenu fm=entityManager.find(FoodMenu.class, id);
			
		fm.setCost(foodMenu.getCost());
		fm.setDescription(foodMenu.getDescription());
		fm.setName(foodMenu.getName());
		
		entityManager.merge(fm);
		entityTransaction.commit();
		System.out.println("updated successfull");
		
	}
	public void deleteFoodMenuById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		FoodMenu foodMenu=entityManager.find(FoodMenu.class, id);
		
		entityTransaction.begin();
		entityManager.remove(foodMenu);
		entityTransaction.commit();
	}
}