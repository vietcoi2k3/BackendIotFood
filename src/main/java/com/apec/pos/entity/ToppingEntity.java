package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ToppingEntity extends BaseEntity{
	private String nameTopping;
	@Column(name = "foodEntityId")
	private Integer foodEntityId;
	@ManyToOne
	@JoinColumn(name = "foodEntityId",updatable = false,insertable = false)
	@JsonBackReference(value = "food-top")
	private FoodEntity foodEntity;
	
	public String getNameTopping() {
		return nameTopping;
	}
	public void setNameTopping(String nameTopping) {
		this.nameTopping = nameTopping;
	}
	public Integer getFoodEntityId() {
		return foodEntityId;
	}
	public void setFoodEntityId(Integer foodEntityId) {
		this.foodEntityId = foodEntityId;
	}
	public FoodEntity getFoodEntity() {
		return foodEntity;
	}
	public void setFoodEntity(FoodEntity foodEntity) {
		this.foodEntity = foodEntity;
	}
}
