package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "user")
public class AccountController {
	
	@Autowired
    private	AccountService accountService;
	
	@RequestMapping(value = "/get-user-info")
	public Response getUserInfo(HttpServletRequest request) {
		String token= request.getHeader("Authorization").substring(7);
		return new Response(true,"lấy thành công",ErrorCode.SUCCESS,accountService.getUserInfo(token));
	}
}
