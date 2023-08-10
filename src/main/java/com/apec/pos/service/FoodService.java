package com.apec.pos.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.FootDto.FoodRecommanDto;
import com.apec.pos.entity.FoodEntity;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.serviceInterface.FoodInterface;


@Service
@CacheConfig(cacheNames = "iotFood")
public class FoodService extends BaseService<FoodRepository, FoodEntity, Integer> implements FoodInterface{

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	FoodRepository getRepository() {
		// TODO Auto-generated method stub
		return foodRepository;
	}

	@Override
	public List<FoodRecommanDto> getFoodRecommand() {
	    List<FoodEntity> foodEntitys= foodRepository.getTopFood();
	    System.out.println(foodEntitys.size());
		List<FoodRecommanDto> foodRecommanDtos = new ArrayList<FoodRecommanDto>();
		for (FoodEntity x : foodEntitys) {
			String nameRes = x.getRestaurantEntity().getRestaurantName();
			long distance = x.getRestaurantEntity().getDistance();
			FoodRecommanDto temp = new FoodRecommanDto(x.getId(),x.getFoodName(),x.getPrice(),nameRes,x.getImgFoodEntities().get(0).getImgFood(),distance,x.getTimeout(),x.getStar(),x.getQuantity());
			foodRecommanDtos.add(temp);
		}
		System.out.println(foodRecommanDtos.size());
		return foodRecommanDtos;
	}

	@Override
	public FoodEntity addFood(FoodEntity foodEntity) {
		return foodRepository.insert(foodEntity);
	}

	@Override
	public List<FoodEntity> findFoodOnType(FoodEntity foodEntity) {
		return foodRepository.findFoodOnType(foodEntity);
	}

	@Override
	public List<FoodEntity> searchFood(String searchString) {
		return foodRepository.findFoodByKey(searchString);
	}
	
	


}
