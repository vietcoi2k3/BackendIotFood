package com.apec.pos.service.serviceInterface;

import java.util.List;

import com.apec.pos.Dto.copy.restaurantDto.ResRecommnedRespon;
import com.apec.pos.Dto.copy.restaurantDto.SearchForm;
import com.apec.pos.entity.RestaurantEntity;

public interface RestaurantInterface {
	public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity);
	public List<ResRecommnedRespon> getRecommendRes();
	public RestaurantEntity getResdetail(Integer id);
	public List<SearchForm> searchRes(String key);
}
