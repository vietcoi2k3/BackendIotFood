package com.apec.pos.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.FoodRecommanDto;
import com.apec.pos.entity.FoodEntity;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.serviceInterface.FoodInterface;


@Service
public class FoodService extends BaseService<FoodRepository, FoodEntity, Integer> implements FoodInterface{

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	FoodRepository getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodRecommanDto getFoodRecommand() {
		foodRepository.getTopFood();
		return null;
	}

}
