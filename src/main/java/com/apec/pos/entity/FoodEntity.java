package com.apec.pos.entity;

import java.io.Serializable;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodEntity extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7836601664079901583L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String foodName;
	
	@Column
	private String detail;
	
	@Column
	private long price;
	
	@Column
	private double star;
	
	@Column
	private long quantity;
	
	@Column
	private long timeout;
	
	@Column
	private long quantityPurchased;
	
	@Column(name = "typeFoodEntityId")
	private long typeFoodEntityId;
	
	@ManyToOne
	@JsonBackReference(value = "type-food")
	@JoinColumn(name = "typeFoodEntityId",updatable = false,insertable = false)
	private TypeFoodEntity typeFoodEntity;

	private String imgFood;
	
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

	public double getStar() {
		return star;
	}
	
	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
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
			String typeFood, String imgFood, long restaurantEntityId, RestaurantEntity restaurantEntity) {
		super(createBy, modifiedBy);
		this.id = id;
		this.foodName = foodName;
		this.detail = detail;
		this.price = price;
		this.imgFood = imgFood;
		this.restaurantEntityId = restaurantEntityId;
		this.restaurantEntity = restaurantEntity;
	}

	public String getImgFood() {
		return imgFood;
	}
	
	

	public long getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(long quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setImgFood(String imgFood) {
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
