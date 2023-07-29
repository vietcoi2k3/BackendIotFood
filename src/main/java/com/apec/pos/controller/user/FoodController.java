package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "get-recommend-food",method = RequestMethod.GET)
	public Response getRecommendFood() {
		return new Response<>(true,"lấy thành công",ErrorCode.SUCCESS,foodService.getFoodRecommand());
	}
}
