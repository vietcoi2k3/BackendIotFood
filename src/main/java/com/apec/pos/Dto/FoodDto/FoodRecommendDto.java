package com.apec.pos.Dto.FoodDto;

import java.util.Date;
import java.util.List;

import com.apec.pos.entity.ToppingEntity;

import io.swagger.models.auth.In;


public class FoodRecommendDto {

	private Integer id;
	private String foodName;
	private Integer price;
	private String detail;
	private String nameRestaurantFood;
	private String imgFood;
	private Double distance;
	private Integer time;
	private Integer star;
	private String createBy;
	private Date createAt;
	private Integer quantityPurchased;
	private Integer typeFoodEntityId;
	private Integer restaurantEntityId;
	private Boolean status;
	private List<ToppingEntity> toppingEntities;
	
	public List<ToppingEntity> getToppingEntities() {
		return toppingEntities;
	}
	
	public void setToppingEntities(List<ToppingEntity> toppingEntities) {
		this.toppingEntities = toppingEntities;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public FoodRecommendDto(Integer id, String foodName, Integer price, String detail, String nameRestaurantFood,
			String imgFood, Double distance, Integer time, Integer star, String createBy,
			Date createAt, Integer quantityPurchased, Integer typeFoodEntityId, Integer restaurantEntityId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.detail = detail;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
		this.distance = distance;
		this.time = time;
		this.star = star;
		this.createBy = createBy;
		this.createAt = createAt;
		this.quantityPurchased = quantityPurchased;
		this.typeFoodEntityId = typeFoodEntityId;
		this.restaurantEntityId = restaurantEntityId;
	}
	
	
	public FoodRecommendDto(Integer id, String foodName, Integer price, String detail, String imgFood, Integer time, Integer quantityPurchased, Integer typeFoodEntityId, Integer restaurantEntityId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.detail = detail;
		this.imgFood = imgFood;
		this.time = time;
		this.quantityPurchased = quantityPurchased;
		this.typeFoodEntityId = typeFoodEntityId;
		this.restaurantEntityId = restaurantEntityId;
	}
	
	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}
	
	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public FoodRecommendDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
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
	public FoodRecommendDto(Integer id, String foodName, Integer price, String nameRestaurantFood, String imgFood,
			Double distance, Integer time, Integer star, String createBy, Date createAt,
			Integer typeFoodEntityId, Integer restaurantEntityId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
		this.distance = distance;
		this.time = time;
		this.star = star;
		this.createBy = createBy;
		this.createAt = createAt;
		this.typeFoodEntityId = typeFoodEntityId;
		this.restaurantEntityId = restaurantEntityId;
	}
	public FoodRecommendDto(Integer id, String foodName, Integer price, String nameRestaurantFood, String imgFood,
			Double distance, Integer time, Integer star ) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.nameRestaurantFood = nameRestaurantFood;
		this.imgFood = imgFood;
		this.distance = distance;
		this.time = time;
		this.star = star;
	}
	
	
	
	
}
