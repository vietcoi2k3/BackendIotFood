package com.apec.pos.controller.admin.controller;

import java.io.IOException;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apec.pos.entity.FoodEntity;
import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

@RestController
@RequestMapping(value = "ADMIN")
@CrossOrigin	
public class FoodAdminController {
	
	@Autowired
	FoodService foodService;

	@RequestMapping(value = "add-food",method = RequestMethod.POST )
	public Response addFood( 
			@RequestParam String foodName ,
			@RequestParam  long price,
			@RequestParam  String typeFood,
			@RequestParam  MultipartFile imgFood,
			@RequestParam String detail,
			@RequestParam  long restaurantId
			) {
			FoodEntity f = new FoodEntity();
			String fileName = StringUtils.cleanPath(imgFood.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("not a a valid file");
			}
			try {
				f.setImgFood(imgFood.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			f.setDetail(detail);
			f.setPrice(price);
			f.setFoodName(foodName);
			f.setRestaurantEntityId(restaurantId);
			RestaurantEntity restaurantEntity =new RestaurantEntity();
			restaurantEntity.setId(restaurantId);
			f.setRestaurantEntity(restaurantEntity);
			return new Response(true,"thành công",foodService.addFood(f));

	}
	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
