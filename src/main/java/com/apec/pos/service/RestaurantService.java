package com.apec.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.repository.RestaurantRepository;
import com.apec.pos.service.serviceInterface.RestaurantInterface;

@Service
public class RestaurantService extends BaseService<RestaurantRepository, RestaurantEntity, Long> implements RestaurantInterface {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	RestaurantRepository getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity) {
		return restaurantRepository.insert(restaurantEntity);
	}

}
