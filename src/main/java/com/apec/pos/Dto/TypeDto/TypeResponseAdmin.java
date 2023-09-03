package com.apec.pos.Dto.TypeDto;

import java.util.List;

import com.apec.pos.entity.TypeFoodEntity;

public class TypeResponseAdmin {

    private Long totalRow;
    private List<TypefoodResponseData> data;

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }

    public List<TypefoodResponseData> getData() {
        return data;
    }

    public void setData(List<TypefoodResponseData> data) {
        this.data = data;
    }

}
