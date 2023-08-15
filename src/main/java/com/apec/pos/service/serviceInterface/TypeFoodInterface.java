package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.copy.TypeDto.AddTypeRequest;
import com.apec.pos.Dto.copy.TypeDto.TypefoodResponseData;
import com.apec.pos.Dto.copy.TypeDto.UpdateTypeRequest;
import com.apec.pos.entity.TypeFoodEntity;

public interface TypeFoodInterface {
	public TypefoodResponseData addTypeFood(AddTypeRequest addTypeRequest);
	public TypefoodResponseData updateTypeFood(UpdateTypeRequest updateTypeRequest);
	public TypefoodResponseData updateStatusType(Integer id,Boolean status);
	public String deleteType(Integer id);
}
