package com.apec.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "iotFood")
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
	@CachePut(key = "2")
	public String hello() {
		String temp="hello";
		return temp;
	}
	
	@RequestMapping(value = "test-cache",method = RequestMethod.GET)
	@Cacheable(key = "5")
	public String testCache() {
		System.out.println("đã gọi");
		return "đã hoạt động";
	}
}
