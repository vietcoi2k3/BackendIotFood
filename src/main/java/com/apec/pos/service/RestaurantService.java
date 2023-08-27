package com.apec.pos.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.restaurantDto.ResRecommnedRespon;
import com.apec.pos.Dto.restaurantDto.ResRequest;
import com.apec.pos.Dto.restaurantDto.SearchForm;
import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.repository.RestaurantRepository;
import com.apec.pos.service.serviceInterface.RestaurantInterface;

@Service
public class RestaurantService extends BaseService<RestaurantRepository, RestaurantEntity, Integer> implements RestaurantInterface {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Override
	RestaurantRepository getRepository() {
		// TODO Auto-generated method stub
		return restaurantRepository;
	}

	@Override
	public RestaurantEntity addRestaurant(ResRequest request) {
		RestaurantEntity restaurantEntity = new RestaurantEntity();
		restaurantEntity.setRestaurantName(request.getRestaurantName());
		restaurantEntity.setAddress(request.getAddress());
		restaurantEntity.setBusinessHours(request.getBusinessHours());
		restaurantEntity.setDetail(request.getDetail());
		restaurantEntity.setPhoneNumber(request.getPhoneNumber());
		if (request.getImgRes()!=null) {
			String imgRes= null;
			try {
				imgRes = fileUploadService.uploadFile(request.getImgRes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			restaurantEntity.setImgRes(imgRes);
		}
		restaurantEntity.setDistance(request.getDistance());
		return restaurantRepository.insert(restaurantEntity);
	}
	
	@Override
	public List<ResRecommnedRespon> getRecommendRes(){
		List<RestaurantEntity> restaurantEntities = restaurantRepository.getRecommendRes();
		List<ResRecommnedRespon> resRecommnedRespons = new ArrayList<>();
		for (RestaurantEntity x : restaurantEntities) {
			ResRecommnedRespon temp = new ResRecommnedRespon(x.getId(), x.getRestaurantName(), x.getQuantitySold(), x.getBusinessHours(),  x.getDistance(), x.getPhoneNumber(),x.getAddress(),x.getImgRes());
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

	@Override
	public ResRecommnedRespon updateRes(ResRequest request) {
		RestaurantEntity restaurantEntity = restaurantRepository.findOne(request.getId());
		ResRecommnedRespon recommnedRespon = new ResRecommnedRespon();
		if (request.getAddress() != null) 
			restaurantEntity.setAddress(request.getAddress());
		if (request.getBusinessHours()!=null)
			restaurantEntity.setBusinessHours(request.getBusinessHours());
		if (request.getDetail()!=null)
			restaurantEntity.setDetail(request.getDetail());
		if (request.getDistance()!=null)
			restaurantEntity.setDistance(request.getDistance());
		if (request.getImgRes()!=null)
		{
			String imgRes=null;
			
			try {
				imgRes=fileUploadService.uploadFile(request.getImgRes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			restaurantEntity.setImgRes(imgRes);
		}
		if (request.getPhoneNumber()!=null)
			restaurantEntity.setPhoneNumber(request.getPhoneNumber());
		if (request.getQuantitySold()!=null)
			restaurantEntity.setQuantitySold(request.getQuantitySold());
		if (request.getRestaurantName()!=null)
			restaurantEntity.setRestaurantName(request.getRestaurantName());
		restaurantEntity = restaurantRepository.update(restaurantEntity);
			recommnedRespon.setAddress(restaurantEntity.getAddress());
			recommnedRespon.setBusinessHours(restaurantEntity.getBusinessHours());
			recommnedRespon.setDistance(restaurantEntity.getDistance());
			recommnedRespon.setId(restaurantEntity.getId());
//			recommnedRespon.setImgRes();
		return null;
	}

	@Override
	public Set<Integer> deleteRes(Set<Integer> ids) {
		for (Integer x : ids) {
			restaurantRepository.delete(x);
		}
		return null;
	}
}
