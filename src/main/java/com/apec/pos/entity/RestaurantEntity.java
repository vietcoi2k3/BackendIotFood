package com.apec.pos.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RestaurantEntity extends BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String restaurantName;
	
	private String adress;
	
	private long distance;
	
	private String phoneNumber;
	
	@OneToMany(mappedBy = "restaurantEntity")
	@JsonManagedReference(value = "food-res")
	@ApiModelProperty(hidden = true)
	private Set<FoodEntity> foodEntities;

	public RestaurantEntity() {
	
	}
	
	public RestaurantEntity(String createBy, String modifiedBy) {
		super(createBy, modifiedBy);
	}

	public RestaurantEntity(String createBy, String modifiedBy, long id, String restaurantName, String adress,
			long distance, String phoneNumber, Set<FoodEntity> foodEntities) {
		super(createBy, modifiedBy);
		this.id = id;
		this.restaurantName = restaurantName;
		this.adress = adress;
		this.distance = distance;
		this.phoneNumber = phoneNumber;
		this.foodEntities = foodEntities;
	}

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

	@ApiModelProperty(hidden = true)
	public Set<FoodEntity> getFoodEntities() {
		return foodEntities;
	}

	@ApiModelProperty(hidden = true)
	public void setFoodEntities(Set<FoodEntity> foodEntities) {
		this.foodEntities = foodEntities;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
