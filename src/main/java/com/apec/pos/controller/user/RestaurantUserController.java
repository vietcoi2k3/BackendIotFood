package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "user")
public class RestaurantUserController {
	
	@Autowired
	private RestaurantService restaurantService;
	

}
