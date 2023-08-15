package com.apec.pos.Dto.copy.FoodDto;

import java.util.Date;
import java.util.List;

public class FoodResponseAdmin {
	
	private long totalPage;
	private List<FoodRecommanDto> data;
	
	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public List<FoodRecommanDto> getFoodRecommanDto() {
		return data;
	}

	public void setFoodRecommanDto(List<FoodRecommanDto> data) {
		this.data = data;
	}

	public FoodResponseAdmin(long totalPage, List<FoodRecommanDto> data) {
		super();
		this.totalPage = totalPage;
		this.data = data;
	}
}
