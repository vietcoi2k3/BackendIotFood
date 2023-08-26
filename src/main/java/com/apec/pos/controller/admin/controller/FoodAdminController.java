package com.apec.pos.controller.admin.controller;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.FoodDto.AddFoodRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "ADMIN")
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class FoodAdminController {
	
	@Autowired
	FoodService foodService;

	@Operation(description = "Endpoint thêm món ăn mới\n\nĐây là endpoint để thêm một món ăn mới vào hệ thống.\n\nThông tin về món ăn cần được cung cấp qua các tham số:\n\n- '<b>foodName</b>': Tên của món ăn.\n\n- '<b>price</b>': Giá của món ăn (kiểu số nguyên).\n\n- '<b>typeFood</b>': Loại món ăn (kiểu số nguyên).\n\n- '<b>imgFood</b>': Hình ảnh của món ăn (định dạng file hình ảnh).\n\n- '<b>detail</b>': Chi tiết về món ăn.\n\n- '<b>restaurantId</b>': ID của nhà hàng mà món ăn thuộc về (kiểu số nguyên).\n\nSau khi thêm thành công, hệ thống sẽ trả về phản hồi với thông tin về món ăn đã được thêm.",
	           summary = "Thêm món ăn mới")
	@RequestMapping(value = "add-food",method = RequestMethod.POST,consumes = "multipart/form-data" )
	public ResponseEntity addFood( 
			@ModelAttribute AddFoodRequest addFoodRequest
			)  {
		
			return ResponseEntity.ok(new Response(true,"Thành công",ErrorCode.SUCCESS,foodService.addFood(addFoodRequest)));	
	}
	
	@RequestMapping(value = "update-food",method = RequestMethod.PUT,consumes = "multipart/form-data")
	@Operation(summary = "sửa món ăn",description = "lưu ý truyền id")
	public ResponseEntity updateFood(@ModelAttribute AddFoodRequest addFoodRequest) {
		try {
			return ResponseEntity.ok(new Response(true,"Thành công",ErrorCode.SUCCESS,foodService.updateFood(addFoodRequest)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "update-status-food",method = RequestMethod.PUT)
	@Operation(summary = "sửa status")
	public ResponseEntity updateStatusFood(@RequestParam Integer id,@RequestParam Boolean status) {
		return ResponseEntity.ok(new Response(true,"Thành công",ErrorCode.SUCCESS,foodService.updateStatusFood(id,status)));
	}
	
	@RequestMapping(value = "delete-food",method = RequestMethod.DELETE)
	@Operation(summary = "xóa món ăn")
	public ResponseEntity deleteFood(@RequestParam Integer id) {
		return ResponseEntity.ok(new Response(true,"Thành công",ErrorCode.SUCCESS,foodService.deleteFood(id)));
	}
	
	@Operation(summary = "phân trang sản phẩm",description = "pageIndex nhận vào tính từ 0")
	@RequestMapping(value = "/paging-food-admin",method = RequestMethod.POST)
	public ResponseEntity pagingFood(@RequestParam int pageSize,@RequestParam int pageIndex) {
		return ResponseEntity.ok(new Response(true,"trang"+pageIndex,ErrorCode.SUCCESS,foodService.paging(pageSize,pageIndex)));
	}
	
	@Operation(summary = "xoá nhiều sản phẩm")
	@RequestMapping(value = "/multi-delete",method = RequestMethod.POST)
	public ResponseEntity multiDelete(@RequestBody Set<Integer> ids) {
		return ResponseEntity.ok(new Response(true,"",foodService.MuiltiDelete(ids)));
	}
}
