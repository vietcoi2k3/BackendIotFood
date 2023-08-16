package com.apec.pos.Dto.copy.FoodDto;

import java.util.Date;
import java.util.List;

public class FoodResponseAdmin {
	
	private long totalPage;
	private List<FoodRecommendDto> data;
	
	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public List<FoodRecommendDto> getData() {
		return data;
	}

	public void setData(List<FoodRecommendDto> data) {
		this.data = data;
	}

	public FoodResponseAdmin(long totalPage, List<FoodRecommendDto> data) {
		super();
		this.totalPage = totalPage;
		this.data = data;
	}
}
