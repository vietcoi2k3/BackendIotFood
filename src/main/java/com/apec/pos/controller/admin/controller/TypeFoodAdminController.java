package com.apec.pos.controller.admin.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.copy.TypeDto.AddTypeRequest;
import com.apec.pos.Dto.copy.TypeDto.UpdateTypeRequest;
import com.apec.pos.entity.TypeFoodEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.TypeFoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class TypeFoodAdminController {
	
	@Autowired
	private TypeFoodService typeFoodService;
	
	//thêm
	@Operation(description = "",summary = "thêm loại món ăn mới")
	@RequestMapping(value = "add-type",method =RequestMethod.POST)
	public ResponseEntity addTypeFood(@RequestBody AddTypeRequest addTypeRequest) {
		return ResponseEntity.ok(new Response<>(true,"thêm thành công",ErrorCode.SUCCESS,typeFoodService.addTypeFood(addTypeRequest)));
	}
	
	//sửa
	@Operation(description = "",summary = "sửa loại món ăn")
	@RequestMapping(value = "update-type",method =RequestMethod.PUT)
	public ResponseEntity updateTypeFood(@RequestBody UpdateTypeRequest updateTypeRequest){
		return ResponseEntity.ok(new Response<>(true,"sửa thành công",ErrorCode.SUCCESS,typeFoodService.updateTypeFood(updateTypeRequest)));
	}
	
	//sửa status
	@Operation(description = "",summary = "sửa status của type")
	@RequestMapping(value = "update-status",method =RequestMethod.PUT)
	public ResponseEntity updateStatusType(@RequestParam Integer id,@RequestParam Boolean status){
		return ResponseEntity.ok(new Response<>(true,"sửa thành công",ErrorCode.SUCCESS,typeFoodService.updateStatusType(id,status)));
	
	}
	
	@Operation(description = "",summary = "xóa vĩnh viễn type")
	@RequestMapping(value = "update-status",method =RequestMethod.DELETE)
	public ResponseEntity deleteType(@RequestParam Integer id) {
		return ResponseEntity.ok(new Response<>(true,"xóa thành công",ErrorCode.SUCCESS,typeFoodService.deleteType(id)));
	}
	
	@Operation(summary = "lấy ra tất cả typeFood theo trang",description = "pageIndex nhận vào tính từ 0")
	@RequestMapping(value = "paging-type-admin",method = RequestMethod.POST)
	public ResponseEntity pagingType(@RequestParam int pageSize,@RequestParam int pageIndex) {
		return ResponseEntity.ok(new Response(true,"trang"+pageIndex,ErrorCode.SUCCESS,typeFoodService.paging(pageSize,pageIndex)));
	}
	
	@RequestMapping(value = "muilti-delete-type",method = RequestMethod.DELETE)
	@Operation(summary = "xóa nhiều type")
	public ResponseEntity MultiDelete(@RequestBody Set<Integer> ids) {
		return ResponseEntity.ok(new Response(true,"",typeFoodService.MultiDelete(ids)));
	}
}
