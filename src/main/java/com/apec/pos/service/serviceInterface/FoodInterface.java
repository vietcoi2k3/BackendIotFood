package com.apec.pos.service.serviceInterface;

import java.util.List;

import com.apec.pos.Dto.copy.FoodDto.AddFoodRequest;
import com.apec.pos.Dto.copy.FoodDto.FoodRecommanDto;
import com.apec.pos.Dto.copy.FoodDto.FoodResponseAdmin;
import com.apec.pos.Dto.copy.FoodDto.FoodSearchRespon;
import com.apec.pos.entity.FoodEntity;

public interface FoodInterface {

	public List<FoodRecommanDto> getFoodRecommand();
	public FoodRecommanDto addFood(AddFoodRequest addFoodRequest);
	public List<FoodEntity> findFoodOnType(FoodEntity foodEntity);
	public List<FoodSearchRespon> searchFood(String searchString);
	public FoodEntity getDetailFood(Integer id);
	public FoodResponseAdmin paging(int pageSize,int pageIndex);
	public FoodRecommanDto updateFood(AddFoodRequest addFoodRequest);
	public String updateStatusFood(Integer id,Boolean status);
	public String deleteFood(Integer id);
}
