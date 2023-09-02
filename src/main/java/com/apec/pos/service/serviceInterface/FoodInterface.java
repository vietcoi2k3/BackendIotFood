package com.apec.pos.service.serviceInterface;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.apec.pos.Dto.FoodDto.AddFoodRequest;
import com.apec.pos.Dto.FoodDto.FoodRecommendDto;
import com.apec.pos.Dto.FoodDto.FoodResponseAdmin;
import com.apec.pos.Dto.ToppingDTO.ToppingRequest;
import com.apec.pos.entity.FoodEntity;

public interface FoodInterface {

	public List<FoodRecommendDto> getFoodRecommand();
	public FoodRecommendDto addFood(AddFoodRequest addFoodRequest, List<ToppingRequest> toppingRequests) throws IOException;

	public List<FoodEntity> findFoodOnType(FoodEntity foodEntity);

	public List<FoodRecommendDto> searchFood(String searchString);

	public FoodRecommendDto getDetailFood(Integer id);

	public FoodResponseAdmin paging(int pageSize,int pageIndex);

	public FoodRecommendDto updateFood(AddFoodRequest addFoodRequest) throws IOException;

	public String updateStatusFood(Integer id,Boolean status);

	public String deleteFood(Integer id);

	public List<Integer> MuiltiDelete(Set<Integer> ids);
}
