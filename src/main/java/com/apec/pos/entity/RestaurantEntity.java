package com.apec.pos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
//@Builder
public class RestaurantEntity extends BaseEntity implements Serializable{

	private String restaurantName;
	
	private String address;
	
	private Integer quantitySold;
	
	private Date businessHours;
	
	private Double distance;
	
	private String detail;
	
	private String phoneNumber;
	
	private String imgRes;

	private Integer time;
	
	@OneToMany(mappedBy = "restaurantEntity",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "food-res")
	private Set<FoodEntity> foodEntities;

	public RestaurantEntity(String createBy, String modifiedBy, String restaurantName, String address,
			Integer quantitySold, Date businessHours, Double distance, String phoneNumber, String imgRes,
			Set<FoodEntity> foodEntities) {
		super(createBy, modifiedBy);
		this.restaurantName = restaurantName;
		this.address = address;
		this.quantitySold = quantitySold;
		this.businessHours = businessHours;
		this.distance = distance;
		this.phoneNumber = phoneNumber;
		this.imgRes = imgRes;
		this.foodEntities = foodEntities;
	}

	public String getImgRes() {
		return imgRes;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setImgRes(String imgRes) {
		this.imgRes = imgRes;
	}

	public RestaurantEntity() {
	
	}
	
	public RestaurantEntity(String createBy, String modifiedBy) {
		super(createBy, modifiedBy);
	}

	public Integer getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}

	public Date getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(Date businessHours) {
		this.businessHours = businessHours;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
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

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
