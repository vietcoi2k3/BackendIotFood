package com.apec.pos.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeFoodEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	private String nameType;
	
	@OneToMany(mappedBy = "typeFoodEntity")
	@JsonBackReference
	private Set<FoodEntity> foodEntities;

	public TypeFoodEntity(String createBy, String modifiedBy, Integer id, String nameType) {
		super(createBy, modifiedBy);
		this.id = id;
		this.nameType = nameType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	
	
	
}
