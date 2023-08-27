package com.apec.pos.Dto.restaurantDto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ResRequest {
	
	private Integer id;
	private String restaurantName;
	private String address;
	private Integer quantitySold;
	private Date businessHours;
	private Double distance;
	private String detail;
	private String phoneNumber;
	private MultipartFile imgRes;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public MultipartFile getImgRes() {
		return imgRes;
	}
	public void setImgRes(MultipartFile imgRes) {
		this.imgRes = imgRes;
	}
}
