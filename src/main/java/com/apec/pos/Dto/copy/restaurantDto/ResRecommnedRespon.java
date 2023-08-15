package com.apec.pos.Dto.copy.restaurantDto;

import java.util.Date;

public class ResRecommnedRespon {

	private Integer id;
	private String restaurantName;
	private Integer quantitySold;
	private Date businessHours;
	private Integer distance;
	private String phoneNumber;
	private String address;
	private String imgRes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgRes() {
		return imgRes;
	}
	public void setImgRes(String imgRes) {
		this.imgRes = imgRes;
	}
	public ResRecommnedRespon(Integer id, String restaurantName, Integer quantitySold, Date businessHours,
			Integer distance, String phoneNumber, String address, String imgRes) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.quantitySold = quantitySold;
		this.businessHours = businessHours;
		this.distance = distance;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.imgRes = imgRes;
	}
		
	
	
	
	
}
