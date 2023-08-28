package com.apec.pos.Dto.restaurantDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResRecommnedRespon {

	private Integer id;
	private String restaurantName;
	private Integer quantitySold;
	private Date businessHours;
	private Double distance;
	private String phoneNumber;
	private String address;
	private String imgRes;
	private Integer time;
	private String detail;

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
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
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
			Double distance, String phoneNumber, String address, String imgRes) {
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
