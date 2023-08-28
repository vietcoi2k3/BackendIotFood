package com.apec.pos.Dto.FoodDto;

import java.util.Date;
import java.util.List;

import com.apec.pos.entity.ToppingEntity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodRecommendDto {

	private Integer id;
	private String foodName;
	private Integer price;
	private String detail;
	private String nameRestaurantFood;
	private String imgFood;
	private Integer star;
	private String createBy;
	private Date createAt;
	private Integer quantityPurchased;
	private Integer typeFoodEntityId;
	private Integer restaurantEntityId;
	private Boolean status;
	private List<ToppingEntity> toppingEntities;


}
