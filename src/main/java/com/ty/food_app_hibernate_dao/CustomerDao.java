package com.ty.food_app_hibernate_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app_hibernate_dto.Customer;


public class CustomerDao {

	
	public void SaveCustomer(Customer customer) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("saved successfully");
	}
	public List<Customer> getAllCustomers(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="select c from Customer c ";
		Query query=entityManager.createQuery(q);
		
		List<Customer> customers=query.getResultList();
		
		for(Customer c:customers) {
			System.out.println(c);
		}
		return customers;
	}
	
	public Customer getCustomerById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="select c from Customer c where c.id=?1";
		Query query=entityManager.createQuery(q);
		query.setParameter(1, id);
		List<Customer> customers=query.getResultList();
		
		Customer customer=customers.get(0);
		System.out.println(customer);
		return customer;
	}
	public boolean deleteCustomer(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Customer customer=entityManager.find(Customer.class, id);
		entityTransaction.begin();
		if(customer!=null) {
			entityManager.remove(customer);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
}
