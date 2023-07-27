package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String foodName;
	
	private String detail;
	
	private long price;
	
	private String typeFood;
	
    @Column(name = "roleid", insertable = false, updatable = false)
	private long restaurantEntityId;
	
	@ManyToOne
	@JoinColumn(name = "restaurantEntityId")
	@JsonBackReference
	private RestaurantEntity restaurantEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getTypeFood() {
		return typeFood;
	}

	public void setTypeFood(String typeFood) {
		this.typeFood = typeFood;
	}

	public long getRestaurantEntityId() {
		return restaurantEntityId;
	}

	public void setRestaurantEntityId(long restaurantEntityId) {
		this.restaurantEntityId = restaurantEntityId;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}
	
	
	
	
}
