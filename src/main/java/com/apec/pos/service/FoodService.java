package com.apec.pos.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.FoodDto.AddFoodRequest;
import com.apec.pos.Dto.copy.FoodDto.FoodRecommendDto;
import com.apec.pos.Dto.copy.FoodDto.FoodResponseAdmin;
import com.apec.pos.Dto.copy.FoodDto.FoodSearchRespon;
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
	public List<FoodRecommendDto> getFoodRecommand() {
	    List<FoodEntity> foodEntitys= foodRepository.getTopFood();
	    System.out.println(foodEntitys.size());
		List<FoodRecommendDto> foodRecommanDtos = new ArrayList<FoodRecommendDto>();
		for (FoodEntity x : foodEntitys) {
			String nameRes = x.getRestaurantEntity().getRestaurantName();
			long distance = x.getRestaurantEntity().getDistance();
			FoodRecommendDto temp = 
					new FoodRecommendDto(
							x.getId(),
							x.getFoodName(),
							x.getPrice(),
							x.getDetail(),
							nameRes,
							x.getImgFood(),
							(int) distance,
							x.getTimeout(),
							(int) x.getStar(),
							x.getQuantity(),
							x.getCreateBy(),
							x.getCreateDate(),
							x.getQuantityPurchased(),
							x.getTypeFoodEntityId(),
							x.getRestaurantEntityId()
							);
						
			foodRecommanDtos.add(temp);
		}
		System.out.println(foodRecommanDtos.size());
		return foodRecommanDtos;
	}

	@Override
	public FoodRecommendDto addFood(AddFoodRequest addFoodRequest) {
		FoodEntity foodEntity = new FoodEntity();
				   foodEntity.setDetail(addFoodRequest.getDetail());
				   foodEntity.setFoodName(addFoodRequest.getFoodName());
				   foodEntity.setImgFood(addFoodRequest.getImgFood());
				   foodEntity.setPrice((int) addFoodRequest.getPrice());
				   foodEntity.setQuantity((int) addFoodRequest.getQuantity());
				   foodEntity.setRestaurantEntityId(addFoodRequest.getRestaurantEntityId());
				   foodEntity.setTimeout((int) addFoodRequest.getTime());
				   foodEntity.setTypeFoodEntityId(addFoodRequest.getTypeFoodEntityId());
		foodRepository.insert(foodEntity);
		FoodRecommendDto foodRecommanDto = new FoodRecommendDto();
						foodRecommanDto.setFoodName(foodEntity.getFoodName());
						foodRecommanDto.setPrice(foodEntity.getPrice());
						foodRecommanDto.setNameRestaurantFood(foodEntity.getFoodName());
						foodRecommanDto.setImgFood(foodEntity.getImgFood());
						foodRecommanDto.setTime(foodEntity.getTimeout());
						foodRecommanDto.setStar((int) foodEntity.getStar());
						foodRecommanDto.setQuantity(foodEntity.getQuantity());
						foodEntity.setTypeFoodEntityId(foodEntity.getTypeFoodEntityId());
						foodEntity.setRestaurantEntityId(foodEntity.getRestaurantEntityId());
		return foodRecommanDto;
	}

	@Override
	public List<FoodEntity> findFoodOnType(FoodEntity foodEntity) {
		return foodRepository.findFoodOnType(foodEntity);
	}

	@Override
	public List<FoodRecommendDto> searchFood(String searchString) {
		List<FoodEntity> foodEntity =foodRepository.findFoodByKey(searchString);
		List<FoodRecommendDto> foodSearchRespons = new ArrayList<>();
		for (FoodEntity x : foodEntity) {
			String nameRes=x.getRestaurantEntity().getRestaurantName();
			Integer distance = x.getRestaurantEntity().getDistance();
			FoodRecommendDto temp = new FoodRecommendDto(
					x.getId(),
					x.getFoodName(),
					x.getPrice(),
					x.getDetail(),
					nameRes,
					x.getImgFood(),
					distance,
					x.getTimeout(),
					(int) x.getStar(),
					x.getQuantity(),
					x.getCreateBy(),
					x.getCreateDate(),
					x.getQuantityPurchased(),
					x.getTypeFoodEntityId(),
					x.getRestaurantEntityId()
					);
			foodSearchRespons.add(temp);
		}
		return foodSearchRespons;
	}

	@Override
	public FoodRecommendDto getDetailFood(Integer id) {
		FoodEntity x = foodRepository.findOne(id);
		Integer distance = x.getRestaurantEntity().getDistance();
		String nameRes = x.getRestaurantEntity().getRestaurantName();
		FoodRecommendDto temp = new FoodRecommendDto(
				x.getId(),
				x.getFoodName(),
				x.getPrice(),
				x.getDetail(),
				nameRes,
				x.getImgFood(),
				distance,
				x.getTimeout(),
				(int) x.getStar(),
				x.getQuantity(),
				x.getCreateBy(),
				x.getCreateDate(),
				x.getQuantityPurchased(),
				x.getTypeFoodEntityId(),
				x.getRestaurantEntityId()
				);
		return temp;
	}

	@Override
	public FoodResponseAdmin paging(int pageSize, int pageIndex) {
		PageRequest pageRequest =  PageRequest.of(pageIndex, pageSize);
		List<FoodRecommendDto> foodRecommanDtos = new ArrayList<>();
		List<FoodEntity> foodEntities = foodRepository.paging(pageRequest);
		for (FoodEntity x : foodEntities) {
			FoodRecommendDto data = 
					 new FoodRecommendDto(
							x.getId(),
							x.getFoodName(),
							x.getPrice(),
							x.getDetail(),
							"",
							x.getImgFood(),
							null,
							x.getTimeout(),
							(int) x.getStar(),
							x.getQuantity(),
							x.getCreateBy(),
							x.getCreateDate(),
							x.getQuantityPurchased(),
							x.getTypeFoodEntityId(),
							x.getRestaurantEntityId()
							);
			data.setCreateAt(x.getCreateDate());
			data.setCreateBy(x.getCreateBy());
			foodRecommanDtos.add(data);
		}
		
		FoodResponseAdmin foodResponseAdmin = new FoodResponseAdmin(foodRepository.countAll()/pageSize, foodRecommanDtos);
		return foodResponseAdmin;
	}

	@Override
	public FoodRecommendDto updateFood(AddFoodRequest addFoodRequest) {
		FoodEntity foodEntity = foodRepository.findOne(addFoodRequest.getId());
			foodEntity.setDetail(addFoodRequest.getDetail());
		    foodEntity.setFoodName(addFoodRequest.getFoodName());
		    foodEntity.setImgFood(addFoodRequest.getImgFood());
		    foodEntity.setPrice((int) addFoodRequest.getPrice());
		    foodEntity.setQuantity((int) addFoodRequest.getQuantity());
		    foodEntity.setRestaurantEntityId(addFoodRequest.getRestaurantEntityId());
		    foodEntity.setTimeout((int) addFoodRequest.getTime());
		    foodEntity.setTypeFoodEntityId(addFoodRequest.getTypeFoodEntityId());
		foodRepository.update(foodEntity);
		FoodRecommendDto foodRecommanDto = new FoodRecommendDto();
			foodRecommanDto.setFoodName(foodEntity.getFoodName());
			foodRecommanDto.setPrice(foodEntity.getPrice());
			foodRecommanDto.setNameRestaurantFood(foodEntity.getFoodName());
			foodRecommanDto.setImgFood(foodEntity.getImgFood());
			foodRecommanDto.setTime(foodEntity.getTimeout());
			foodRecommanDto.setStar((int) foodEntity.getStar());
			foodRecommanDto.setQuantity(foodEntity.getQuantity());
			foodEntity.setTypeFoodEntityId(foodEntity.getTypeFoodEntityId());
			foodEntity.setRestaurantEntityId(foodEntity.getRestaurantEntityId());
		return foodRecommanDto;
	}

	@Override
	public String updateStatusFood(Integer id, Boolean status) {
		FoodEntity foodEntity = foodRepository.findOne(id);
				  foodEntity.setStatus(status);
		return "Đã Sửa status";
	}

	@Override
	public String deleteFood(Integer id) {
		foodRepository.delete(id);
		return "Đã xóa";
	}
	
	


}
