package com.ty.food_app_hibernate_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app_hibernate_dto.FoodMenu;
import com.ty.food_app_hibernate_dto.FoodOrder;
import com.ty.food_app_hibernate_dto.Item;

public class FoodOrderDao {

	public void SaveFoodOrder(List<Item> items) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setItems(items);

		double cost = 0;
		for (Item i : items) {
			double c = i.getCost();
			double q = (double) i.getQty();
			cost = cost + (c * q);
		}

		foodOrder.setCost(cost);

		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
	}

	public List<FoodOrder> getAllFoodOrders() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String q = "select f from FoodOrder f ";
		Query query = entityManager.createQuery(q);
		List<FoodOrder> fo = query.getResultList();

		for (FoodOrder f : fo) {
			System.out.println(f);

		}

		return fo;
	}

	public FoodOrder getFoodOrderById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String q = "select f from FoodOrder f where f.id=?1";
		Query query = entityManager.createQuery(q);
		query.setParameter(1, id);
		List<FoodOrder> fo = query.getResultList();

		FoodOrder foodOrder = fo.get(0);

		System.out.println(foodOrder);

		return foodOrder;
	}
}
