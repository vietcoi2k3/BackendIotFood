package com.apec.pos.service.serviceInterface;

import java.util.List;

import com.apec.pos.Dto.copy.FoodRecommanDto;
import com.apec.pos.entity.FoodEntity;

public interface FoodInterface {

	public List<FoodRecommanDto> getFoodRecommand();
	public FoodEntity addFood(FoodEntity foodEntity);
}
