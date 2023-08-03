package com.apec.pos.controller.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.response.Response;
import com.apec.pos.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "ADMIN")
public class RestaurantAdminController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Operation(description = "không filed nào là bắt buộc, thích nhập gì thì nhập\n\nếu không nhập gì thì sẽ thêm giá trị null vào trong db",
			summary = "thêm nhà hàng mới")
	@RequestMapping(value = "add-res",method = RequestMethod.POST)
	public Response addRestaurant(@RequestBody RestaurantEntity restaurantEntity) 
	{
		return new Response(true,"thêm thành công",restaurantService.addRestaurant(restaurantEntity));
	}
}
