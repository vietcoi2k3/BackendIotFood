package com.apec.pos.Dto.copy.FoodDto;

import org.springframework.web.multipart.MultipartFile;

public class AddFoodRequest {

	private Integer id;
	private String foodName;
	private Integer price;
	private String detail;
	private Integer distance;
	private Integer time;
	private Integer quantity;
	private MultipartFile imgFood;
	private Integer typeFoodEntityId;
	private Integer restaurantEntityId;
	
	
	public MultipartFile getImgFood() {
		return imgFood;
	}

	public void setImgFood(MultipartFile imgFood) {
		this.imgFood = imgFood;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddFoodRequest(String foodName, Integer price, String nameRestaurantFood, Integer distance,
			Integer time, Integer quantity, Integer typeFoodEntityId, Integer restaurantEntityId) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.distance = distance;
		this.time = time;
		this.quantity = quantity;
		this.typeFoodEntityId = typeFoodEntityId;
		this.restaurantEntityId = restaurantEntityId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTypeFoodEntityId() {
		return typeFoodEntityId;
	}

	public void setTypeFoodEntityId(Integer typeFoodEntityId) {
		this.typeFoodEntityId = typeFoodEntityId;
	}

	public Integer getRestaurantEntityId() {
		return restaurantEntityId;
	}

	public void setRestaurantEntityId(Integer restaurantEntityId) {
		this.restaurantEntityId = restaurantEntityId;
	}
	
	
}
