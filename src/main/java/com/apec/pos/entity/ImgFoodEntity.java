package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ImgFoodEntity extends BaseEntity{
	
	private String imgFood;
	
	@Column(name = "foodEntityId")
	private Integer foodEntityId;
	
	@ManyToOne
	@JoinColumn(name = "foodEntityId",insertable =false,updatable = false)
	@JsonBackReference(value = "food-img")
	private FoodEntity foodEntity;

	public String getImgFood() {
		return imgFood;
	}

	public void setImgFood(String imgFood) {
		this.imgFood = imgFood;
	}
}
