package com.apec.pos.Dto.copy.FoodDto;

import java.util.Date;


public class FoodRecommanDto {

	private long id;
	private String foodName;
	private long price;
	private String nameRestaurantFood;
	private String imgFood;
	private long distance;
	private long time;
	private double star;
	private long quantity;
	private String createBy;
	private Date createAt;
	private Integer typeFtypeFoodEntityIdood;
	private Integer restaurantEntityId;
	
	
	public FoodRecommanDto() {
		super();
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getNameRestaurantFood() {
		return nameRestaurantFood;
	}
	public void setNameRestaurantFood(String nameRestaurantFood) {
		this.nameRestaurantFood = nameRestaurantFood;
	}
	public String getImgFood() {
		return imgFood;
	}
	public void setImgFood(String imgFood) {
		this.imgFood = imgFood;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getStar() {
		return star;
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
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Integer getTypeFtypeFoodEntityIdood() {
		return typeFtypeFoodEntityIdood;
	}
	public void setTypeFtypeFoodEntityIdood(Integer typeFtypeFoodEntityIdood) {
		this.typeFtypeFoodEntityIdood = typeFtypeFoodEntityIdood;
	}
	public Integer getRestaurantEntityId() {
		return restaurantEntityId;
	}
	public void setRestaurantEntityId(Integer restaurantEntityId) {
		this.restaurantEntityId = restaurantEntityId;
	}
	public FoodRecommanDto(long id, String foodName, long price, String nameRestaurantFood, String imgFood,
			long distance, long time, double star, long quantity, String createBy, Date createAt,
			Integer typeFtypeFoodEntityIdood, Integer restaurantEntityId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
		this.distance = distance;
		this.time = time;
		this.star = star;
		this.quantity = quantity;
		this.createBy = createBy;
		this.createAt = createAt;
		this.typeFtypeFoodEntityIdood = typeFtypeFoodEntityIdood;
		this.restaurantEntityId = restaurantEntityId;
	}
	public FoodRecommanDto(long id, String foodName, long price, String nameRestaurantFood, String imgFood,
			long distance, long time, double star, long quantity) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
		this.distance = distance;
		this.time = time;
		this.star = star;
		this.quantity = quantity;
	}
	
	
	
	
}
