package com.apec.pos.entity;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@ApiModel(value = "FoodEntity")
public class FoodEntity extends BaseEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String foodName;
	
	private String detail;
	
	private long price;
	
	@Column(name = "typeFoodEntityId")
	private long typeFoodEntityId;
	
	@ManyToOne
	@JsonBackReference(value = "type-food")
	@JoinColumn(name = "typeFoodEntityId",updatable = false,insertable = false)
	private TypeFoodEntity typeFoodEntity;
	
	@Column(columnDefinition ="bytea")
	private byte[] imgFood;
	
    @Column(name = "restaurantEntityId")
	private long restaurantEntityId;
	
	@ManyToOne
	@JsonBackReference(value = "food-res")
	@JoinColumn(name = "restaurantEntityId",insertable = false, updatable = false)
	private RestaurantEntity restaurantEntity;

	
	
	public FoodEntity() {
	
	}
	
	public long getTypeFoodEntityId() {
		return typeFoodEntityId;
	}



	public void setTypeFoodEntityId(long typeFoodEntityId) {
		this.typeFoodEntityId = typeFoodEntityId;
	}



	public TypeFoodEntity getTypeFoodEntity() {
		return typeFoodEntity;
	}



	public void setTypeFoodEntity(TypeFoodEntity typeFoodEntity) {
		this.typeFoodEntity = typeFoodEntity;
	}

	public FoodEntity(String createBy, String modifiedBy) {
		super(createBy, modifiedBy);
	}

	public FoodEntity(String createBy, String modifiedBy, long id, String foodName, String detail, long price,
			String typeFood, byte[] imgFood, long restaurantEntityId, RestaurantEntity restaurantEntity) {
		super(createBy, modifiedBy);
		this.id = id;
		this.foodName = foodName;
		this.detail = detail;
		this.price = price;
		this.imgFood = imgFood;
		this.restaurantEntityId = restaurantEntityId;
		this.restaurantEntity = restaurantEntity;
	}

	public byte[] getImgFood() {
		return imgFood;
	}

	public void setImgFood(byte[] imgFood) {
		this.imgFood = imgFood;
	}

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
