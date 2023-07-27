package com.apec.pos.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class RestaurantEntity {

	private long id;
	
	private String adress;
	
	private long distance;
	
	private String phoneNumber;
	
	@OneToMany(mappedBy = "restaurantEntity")
	@JsonManagedReference
	private Set<FoodEntity> foodEntities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<FoodEntity> getFoodEntities() {
		return foodEntities;
	}

	public void setFoodEntities(Set<FoodEntity> foodEntities) {
		this.foodEntities = foodEntities;
	}
	
	
}
