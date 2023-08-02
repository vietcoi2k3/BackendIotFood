package com.apec.pos.controller.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.entity.TypeFoodEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.TypeFoodService;

@RestController
@RequestMapping(value = "ADMIN")
public class TypeFoodAdminController {
	
	@Autowired
	private TypeFoodService typeFoodService;
	
	@RequestMapping(value = "add-type",method =RequestMethod.POST)
	public Response addTypeFood(@RequestBody TypeFoodEntity typeFoodEntity) {
		return new Response<>(true,"thêm thành công",ErrorCode.SUCCESS,typeFoodService.addTypeFood(typeFoodEntity));
	}
}
