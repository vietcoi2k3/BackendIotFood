package com.apec.pos.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.restaurantDto.ResRecommnedRespon;
import com.apec.pos.Dto.copy.restaurantDto.SearchForm;
import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.repository.RestaurantRepository;
import com.apec.pos.service.serviceInterface.RestaurantInterface;

@Service
public class RestaurantService extends BaseService<RestaurantRepository, RestaurantEntity, Integer> implements RestaurantInterface {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	RestaurantRepository getRepository() {
		// TODO Auto-generated method stub
		return restaurantRepository;
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
			ResRecommnedRespon temp = new ResRecommnedRespon(x.getId(), x.getRestaurantName(), x.getQuantitySold(), x.getBusinessHours(), (int) x.getDistance(), x.getPhoneNumber(),x.getAddress(),x.getImgRes());
			resRecommnedRespons.add(temp);
		}
		return resRecommnedRespons;
	}

	@Override
	public RestaurantEntity getResdetail(Integer id) {
		// TODO Auto-generated method stub
		return restaurantRepository.findOne(id);
	}

	@Override
	public List<SearchForm> searchRes(String key) {
		List<RestaurantEntity> restaurantEntities = restaurantRepository.searchRes(key);
		List<SearchForm> searchRes = new ArrayList();
		for (RestaurantEntity x : restaurantEntities) {
			SearchForm searchRess = new SearchForm();
					  searchRess.setId(x.getId());
					  searchRess.setTitle(x.getRestaurantName());
			searchRes.add(searchRess);
		}
		
		return searchRes;
	}

}
