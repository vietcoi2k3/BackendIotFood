package com.apec.pos.Dto.copy;

public class FoodRecommanDto {

	private long id;
	private String nameFood;
	private long price;
	private String nameRestaurantFood;
	private byte[] imgFood;
	
	
	public FoodRecommanDto(long id, String nameFood, long price, String nameRestaurantFood,byte[] imgFood) {
		super();
		this.id = id;
		this.nameFood = nameFood;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood=imgFood;
	}
	
	public byte[] getImgFood() {
		return imgFood;
	}

	public void setImgFood(byte[] imgFood) {
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
