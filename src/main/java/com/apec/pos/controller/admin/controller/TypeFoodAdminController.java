package com.apec.pos.controller.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.entity.TypeFoodEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.TypeFoodService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "ADMIN")
public class TypeFoodAdminController {
	
	@Autowired
	private TypeFoodService typeFoodService;
	
	@Operation(description = "Không field nào bắt buộc",summary = "thêm loại món ăn mới")
	@RequestMapping(value = "add-type",method =RequestMethod.POST)
	public Response addTypeFood(@RequestBody TypeFoodEntity typeFoodEntity) {
		return new Response<>(true,"thêm thành công",ErrorCode.SUCCESS,typeFoodService.addTypeFood(typeFoodEntity));
	}
	
	@Operation(summary = "lấy ra tất cả typeFood theo trang",description = "pageIndex nhận vào tính từ 0")
	@RequestMapping(value = "paging-type-admin",method = RequestMethod.POST)
	public ResponseEntity pagingType(@RequestParam int pageSize,@RequestParam int pageIndex) {
		return ResponseEntity.ok(new Response(true,"trang"+pageIndex,ErrorCode.SUCCESS,typeFoodService.paging(pageSize,pageIndex)));
	}
}
