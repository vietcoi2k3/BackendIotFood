package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "user")
@SecurityRequirement(name = "bearerAuth")
public class AccountController {
	
	@Autowired
    private	AccountService accountService;
	
	
	@Operation(description = "trả về thông tin người dùng đang đăng nhập, dựa trên token",summary = "lấy ra thông tin người dùng hiện tại")
	@RequestMapping(value = "/get-user-info",method = RequestMethod.GET)
	public Response getUserInfo(HttpServletRequest request) {
		String token= request.getHeader("Authorization").substring(7);
		return new Response(true,"lấy thành công",ErrorCode.SUCCESS,accountService.getUserInfo(token));
	}
}
