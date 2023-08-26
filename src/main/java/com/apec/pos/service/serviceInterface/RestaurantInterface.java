package com.apec.pos.service.serviceInterface;

import java.util.List;

import com.apec.pos.Dto.restaurantDto.ResRecommnedRespon;
import com.apec.pos.Dto.restaurantDto.ResRequest;
import com.apec.pos.Dto.restaurantDto.SearchForm;
import com.apec.pos.entity.RestaurantEntity;

public interface RestaurantInterface {
	public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity);
	public List<ResRecommnedRespon> getRecommendRes();
	public RestaurantEntity getResdetail(Integer id);
	public List<SearchForm> searchRes(String key);
	public ResRecommnedRespon updateRes(ResRequest request);
}
