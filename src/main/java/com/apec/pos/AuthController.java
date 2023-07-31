package com.apec.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.entity.AccountEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;


@RestController
@RequestMapping(value = "auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value= "login",method = RequestMethod.POST)
	public Response login(@RequestBody AccountEntity accountEntity) {	
		String token = accountService.login(accountEntity);
		if(token==null) {
			return new Response<>(false,"đăng nhập thất bại",ErrorCode.BAD_REQUEST);
		}
 		return new Response(true,"đăng nhập thành công",ErrorCode.SUCCESS,token);
	}
	
	@RequestMapping(value= "register",method = RequestMethod.POST)
	public Response register(@RequestBody AccountEntity accountEntity) {
		String token =accountService.register(accountEntity);
		
		if(token==null) {
			return new Response<>(false,"tài khoản đã tồn tại",ErrorCode.BAD_REQUEST);
		}
		
		return new Response(true,"đăng nhập thành công",ErrorCode.SUCCESS,token);
	}
	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
