package com.apec.pos.Dto.FoodDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class AddFoodRequest {

	private Integer id;
	private String foodName;
	private Integer price;
	private String detail;
	private MultipartFile imgFood;
	private Integer typeFoodEntityId;
	private Integer restaurantEntityId;
}
