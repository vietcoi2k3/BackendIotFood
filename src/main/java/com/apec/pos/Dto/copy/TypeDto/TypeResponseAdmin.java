package com.apec.pos.Dto.copy.TypeDto;

import java.util.List;

import com.apec.pos.entity.TypeFoodEntity;

public class TypeResponseAdmin {

	private Integer totalPage;
	private List<TypefoodResponseData> data;
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<TypefoodResponseData> getData() {
		return data;
	}
	public void setData(List<TypefoodResponseData> data) {
		this.data = data;
	}
	
}
