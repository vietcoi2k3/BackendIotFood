package com.apec.pos.entity;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class FoodEntity extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	
	@Column
	private String foodName;
	
	@Column
	private String detail;
	
	@Column
	private Integer price;
	
	@Column
	private double star;
	
	@Column
	private Integer quantity;
	
	@Column
	private Integer timeout;
	
	@Column
	private Integer quantityPurchased;
	
	@Column(name = "typeFoodEntityId")
	private Integer typeFoodEntityId;
	
	@ManyToOne
	@JsonBackReference(value = "type-food")
	@JoinColumn(name = "typeFoodEntityId",updatable = false,insertable = false)
	private TypeFoodEntity typeFoodEntity;

	@Column
	private String imgFood;
	
    @Column(name = "restaurantEntityId")
	private Integer restaurantEntityId;
	
	@ManyToOne
	@JsonBackReference(value = "food-res")
	@JoinColumn(name = "restaurantEntityId",insertable = false, updatable = false)
	private RestaurantEntity restaurantEntity;

	
	
	public FoodEntity() {
	
	}
	
	
	
	public String getImgFood() {
		return imgFood;
	}



	public void setImgFood(String imgFood) {
		this.imgFood = imgFood;
	}



	public FoodEntity(String createBy, String modifiedBy, String foodName, String detail, Integer price, double star,
			Integer quantity, Integer timeout, Integer quantityPurchased, Integer typeFoodEntityId, TypeFoodEntity typeFoodEntity,
			 Integer restaurantEntityId, RestaurantEntity restaurantEntity) {
		super(createBy, modifiedBy);
		this.foodName = foodName;
		this.detail = detail;
		this.price = price;
		this.star = star;
		this.quantity = quantity;
		this.timeout = timeout;
		this.quantityPurchased = quantityPurchased;
		this.typeFoodEntityId = typeFoodEntityId;
		this.typeFoodEntity = typeFoodEntity;
		this.restaurantEntityId = restaurantEntityId;
		this.restaurantEntity = restaurantEntity;
	}



	public Integer getTypeFoodEntityId() {
		return typeFoodEntityId;
	}
	
	public double getStar() {
		return star;
	}
	
	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setTypeFoodEntityId(Integer typeFoodEntityId) {
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

	public FoodEntity(String createBy, String modifiedBy, Integer id, String foodName, String detail, Integer price,
			String typeFood, String imgFood, Integer restaurantEntityId, RestaurantEntity restaurantEntity) {
		super(createBy, modifiedBy);
	
		this.foodName = foodName;
		this.detail = detail;
		this.price = price;
		this.restaurantEntityId = restaurantEntityId;
		this.restaurantEntity = restaurantEntity;
	}
	
	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRestaurantEntityId() {
		return restaurantEntityId;
	}

	public void setRestaurantEntityId(Integer restaurantEntityId) {
		this.restaurantEntityId = restaurantEntityId;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}
	
	
	
	
}
