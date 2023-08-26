package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.accountDto.AccountInfoDto;
import com.apec.pos.Dto.accountDto.AccountResponseAdmin;
import com.apec.pos.Dto.accountDto.LoginRequest;
import com.apec.pos.Dto.accountDto.LoginResponDto;
import com.apec.pos.Dto.accountDto.RegisterRequest;
import com.apec.pos.entity.AccountEntity;

public interface AccountInterface {

	public LoginResponDto login(LoginRequest loginRequest);
	
	public LoginResponDto register(AccountEntity accountEntity);
	
	public AccountInfoDto getUserInfo(String token);

	public LoginResponDto addEmployee(RegisterRequest registerRequest);
	
	public AccountInfoDto updateAccountInfo(RegisterRequest updateRequest)throws Exception;
	
	public AccountResponseAdmin paging(Integer pageSize,Integer pageIndex);
}
