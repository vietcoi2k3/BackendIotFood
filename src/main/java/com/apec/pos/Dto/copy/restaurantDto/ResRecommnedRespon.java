package com.apec.pos.Dto.copy.restaurantDto;

import java.util.Date;

public class ResRecommnedRespon {

	private Integer id;
	private String restaurantName;
	private Integer quantitySold;
	private Date businessHours;
	private Integer distance;
	private String phoneNumber;
	private String adress;
		
	public ResRecommnedRespon(Integer id, String restaurantName, Integer quantitySold, Date businessHours,
			Integer distance, String phoneNumber, String adress) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.quantitySold = quantitySold;
		this.businessHours = businessHours;
		this.distance = distance;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public ResRecommnedRespon(Integer id, String restaurantName, Integer quantitySold, Date businessHours,
			Integer distance, String phoneNumber) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.quantitySold = quantitySold;
		this.businessHours = businessHours;
		this.distance = distance;
		this.phoneNumber = phoneNumber;
	}
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
	
	
}
