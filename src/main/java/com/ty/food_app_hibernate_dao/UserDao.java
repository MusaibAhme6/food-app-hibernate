package com.ty.food_app_hibernate_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app_hibernate_dto.User;

public class UserDao {

	public void saveUser(User user) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		System.out.println("saved successfully");
	}
	
	public List<User> getAllUsers(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="select u from User u ";
		Query query=entityManager.createQuery(q);
		
		List<User> users=query.getResultList();
		
		for(User u:users) {
			System.out.println(u);
		}
		return users;
	}
	
	public User getUserById(int id) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="select u from User u where u.id=?1";
		Query query=entityManager.createQuery(q);
		query.setParameter(1, id);
		List<User> users=query.getResultList();
		
		User user=users.get(0);
		System.out.println(user);
		return user;
	}
	
	public boolean deleteUser(int id) {
		

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user=entityManager.find(User.class, id);
		entityTransaction.begin();
		if(user!=null) {
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
		
	}
}
