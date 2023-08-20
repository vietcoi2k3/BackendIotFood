package com.apec.pos.controller.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.copy.accountDto.RegisterRequest;
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
	
	@Operation(summary = "thêm nhân viên")
	@RequestMapping(value = "/MANAGER/add-employee",method = RequestMethod.POST)
	public ResponseEntity addEmployee(@RequestBody RegisterRequest registerRequest) {
		return ResponseEntity.ok(new Response(true,"",accountService.addEmployee(registerRequest)));
	}
}
