package com.apec.pos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.restaurantDto.ResRecommnedRespon;
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
	
	@Override
	public List<ResRecommnedRespon> getRecommendRes(){
		List<RestaurantEntity> restaurantEntities = restaurantRepository.getRecommendRes();
		List<ResRecommnedRespon> resRecommnedRespons = new ArrayList<>();
		for (RestaurantEntity x : restaurantEntities) {
			ResRecommnedRespon temp = new ResRecommnedRespon(x.getId(), x.getRestaurantName(), x.getQuantitySold(), x.getBusinessHours(), (int) x.getDistance(), x.getPhoneNumber());
			resRecommnedRespons.add(temp);
		}
		return resRecommnedRespons;
	}

}
