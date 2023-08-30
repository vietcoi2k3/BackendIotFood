package com.apec.pos.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.accountDto.RegisterRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "ADMIN")
public class AccountAdminController {
	
	@Autowired
	private AccountService accountService;
	

	@Operation(summary = "phân trang người dùng")
	@RequestMapping(value = "paging-user",method = RequestMethod.POST)
	public ResponseEntity pagingAccount(@RequestParam Integer pageSize,@RequestParam Integer pageIndex) {
		return ResponseEntity.ok(new Response(true,"",ErrorCode.SUCCESS,accountService.paging(pageSize,pageIndex)));
	}
	
}
