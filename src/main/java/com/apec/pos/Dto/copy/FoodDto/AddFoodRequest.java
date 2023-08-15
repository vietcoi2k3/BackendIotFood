package com.apec.pos.Dto.copy.FoodDto;

public class AddFoodRequest {

	private Integer id;
	private String foodName;
	private long price;
	private String nameRestaurantFood;
	private String imgFood;
	private String detail;
	private long distance;
	private long time;
	private long quantity;
	private Integer typeFoodEntityId;
	private Integer restaurantEntityId;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddFoodRequest(String foodName, long price, String nameRestaurantFood, String imgFood, long distance,
			long time, double star, long quantity, Integer typeFoodEntityId, Integer restaurantEntityId) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
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
