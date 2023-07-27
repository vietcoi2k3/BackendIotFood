package com.apec.pos.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.response.Response;

@RestController
@RequestMapping(value = "USER")
public class FoodController {
	
	@RequestMapping(value = "/get-recommend-food",method = RequestMethod.GET)
	public Response getRecommendFood() {
		return null;
	}
}
