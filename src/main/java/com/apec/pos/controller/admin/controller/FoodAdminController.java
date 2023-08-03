package com.apec.pos.controller.admin.controller;

import java.io.IOException;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apec.pos.entity.FoodEntity;
import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "ADMIN")
@CrossOrigin	
public class FoodAdminController {
	
	@Autowired
	FoodService foodService;

	@Operation(description = "Endpoint thêm món ăn mới\n\nĐây là endpoint để thêm một món ăn mới vào hệ thống.\n\nThông tin về món ăn cần được cung cấp qua các tham số:\n\n- '<b>foodName</b>': Tên của món ăn.\n\n- '<b>price</b>': Giá của món ăn (kiểu số nguyên).\n\n- '<b>typeFood</b>': Loại món ăn (kiểu số nguyên).\n\n- '<b>imgFood</b>': Hình ảnh của món ăn (định dạng file hình ảnh).\n\n- '<b>detail</b>': Chi tiết về món ăn.\n\n- '<b>restaurantId</b>': ID của nhà hàng mà món ăn thuộc về (kiểu số nguyên).\n\nSau khi thêm thành công, hệ thống sẽ trả về phản hồi với thông tin về món ăn đã được thêm.",
	           summary = "Thêm món ăn mới")
	@RequestMapping(value = "add-food",method = RequestMethod.POST,consumes = "multipart/form-data" )
	public Response addFood( 
			@RequestParam 	String foodName ,
			@RequestParam  long price,
			@RequestParam  long typeFood,
			@RequestPart(required = true)  MultipartFile imgFood,
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
			f.setTypeFoodEntityId(typeFood);
			f.setFoodName(foodName);
			f.setRestaurantEntityId(restaurantId);
			return new Response(true,"thành công",foodService.addFood(f));

	}
	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
	@CachePut(value = "temp",key = "1")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "test-cache",method = RequestMethod.GET)
	@Cacheable(value = "temp",key = "1")
	public String testCache() {
		System.out.println("đã gọi");
		return "không hoạt động";
	}
}
