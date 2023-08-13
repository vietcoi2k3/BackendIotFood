package com.apec.pos.service.serviceInterface;

import java.util.List;


import com.apec.pos.Dto.copy.FoodDto.FoodRecommanDto;
import com.apec.pos.Dto.copy.FoodDto.FoodSearchRespon;
import com.apec.pos.entity.FoodEntity;

public interface FoodInterface {

	public List<FoodRecommanDto> getFoodRecommand();
	public FoodEntity addFood(FoodEntity foodEntity);
	public List<FoodEntity> findFoodOnType(FoodEntity foodEntity);
	public List<FoodSearchRespon> searchFood(String searchString);
	public FoodEntity getDetailFood(Integer id);
}