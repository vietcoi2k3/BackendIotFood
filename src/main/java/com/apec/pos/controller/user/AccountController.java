package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.copy.accountDto.AccountInfoDto;
import com.apec.pos.Dto.copy.accountDto.RegisterRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;
import com.apec.pos.service.JwtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "user")
@SecurityRequirement(name = "bearerAuth")
public class AccountController {
	
	@Autowired
    private	AccountService accountService;
	
	@Autowired
	private JwtService jwtService;
	
	@Operation(description = "trả về thông tin người dùng đang đăng nhập, dựa trên token",summary = "lấy ra thông tin người dùng hiện tại")
	@RequestMapping(value = "/get-user-info",method = RequestMethod.GET)
	public ResponseEntity getUserInfo(HttpServletRequest request) {
		String token= request.getHeader("Authorization").substring(7);
		return ResponseEntity.ok(new Response<>(true,"lấy thông tin thành công",accountService.getUserInfo(token)));
	}
	
	@Operation(summary = "sửa thông người dùng",description = "không cần truyền <b>username</b>, <b>id</b>,tạm thời chưa thể sửa mật khẩu và số điện thoại được")
	@RequestMapping(value = "/update-user-info",method = RequestMethod.POST)
	public ResponseEntity updateUserInfo(HttpServletRequest request,@RequestBody RegisterRequest registerRequest) throws Exception {
		String token= request.getHeader("Authorization").substring(7);
		registerRequest.setUsername(jwtService.getUsernameFromToken(token));
		AccountInfoDto accountInfoDto = accountService.updateAccountInfo(registerRequest);
		if (accountInfoDto==null) {
			return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(true,"mật khẩu không hợp lệ",ErrorCode.BAD_REQUEST));
		}
		return ResponseEntity.ok(new Response(true,"",ErrorCode.SUCCESS,accountInfoDto));
	}
}
 