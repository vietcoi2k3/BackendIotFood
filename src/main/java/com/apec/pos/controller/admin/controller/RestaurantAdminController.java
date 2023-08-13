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
	
	@Operation(description = "Thêm nhà hàng mới.\n\nCác trường không bắt buộc, bạn có thể nhập theo ý muốn.\n\nNếu không nhập giá trị cho một trường nào đó, giá trị null sẽ được thêm vào cơ sở dữ liệu.\n\nCác thông tin bổ sung:\n\n- id (không nhập): Mã nhà hàng (ID) sẽ được tạo tự động bởi hệ thống, bạn không cần phải nhập giá trị cho trường này.\n- \"restaurantName\" <=> \"tên nhà hàng\": Tên của nhà hàng.\n- \"address\" <=> Địa chỉ quán: Địa chỉ của nhà hàng.\n- \"distance\" <=> Khoảng cách từ trường đến quán: Khoảng cách từ trường đến nhà hàng.\n- \"phoneNumber\" <=> Số điện thoại của quán: Số điện thoại liên hệ của nhà hàng.\n- \"foodEntities\" <=> không nhập",
	           summary = "Thêm nhà hàng mới")
	@RequestMapping(value = "add-res",method = RequestMethod.POST)
	public Response addRestaurant(@RequestBody RestaurantEntity restaurantEntity) 
	{
		return new Response(true,"thêm thành công",restaurantService.addRestaurant(restaurantEntity));
	}
}