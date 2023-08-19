package com.apec.pos.Dto.copy.TypeDto;

import java.util.List;

import com.apec.pos.entity.TypeFoodEntity;

public class TypeResponseAdmin {

	private Integer totalRow;
	private List<TypefoodResponseData> data;
	
	public Integer getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}
	public List<TypefoodResponseData> getData() {
		return data;
	}
	public void setData(List<TypefoodResponseData> data) {
		this.data = data;
	}
	
}
