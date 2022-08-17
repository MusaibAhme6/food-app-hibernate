package com.ty.food_app_hibernate_dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class FoodOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private LocalDateTime OrderDateTime;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Item> items;
	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", OrderDateTime=" + OrderDateTime + "\n, items=" + items + ", cost=" + cost + "]";
	}
	private Double cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getOrderDateTime() {
		return OrderDateTime;
	}
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		OrderDateTime = orderDateTime;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public FoodOrder() {
		super();
	}
	
	

}
