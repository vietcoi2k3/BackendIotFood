package com.apec.pos.Dto.copy.FoodDto;

public class FoodRecommanDto {

	private long id;
	private String nameFood;
	private long price;
	private String nameRestaurantFood;
	private String imgFood;
	private long distance;
	private long time;
	private double star;
	private long quantity;
	
	public FoodRecommanDto(long id, String nameFood, long price, String nameRestaurantFood, String imgFood,
			long distance, long time, double star, long quantity) {
		super();
		this.id = id;
		this.nameFood = nameFood;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
		this.distance = distance;
		this.time = time;
		this.star = star;
		this.quantity = quantity;
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

	public String getImgFood() {
		return imgFood;
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
	public String getNameFood() {
		return nameFood;
	}
	public void setNameFood(String nameFood) {
		this.nameFood = nameFood;
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
	
	
}
