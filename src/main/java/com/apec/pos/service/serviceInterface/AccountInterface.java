package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.copy.accountDto.AccountInfoDto;
import com.apec.pos.Dto.copy.accountDto.LoginRequest;
import com.apec.pos.Dto.copy.accountDto.LoginResponDto;
import com.apec.pos.entity.AccountEntity;

public interface AccountInterface {

	public LoginResponDto login(LoginRequest loginRequest);
	
	public LoginResponDto register(AccountEntity accountEntity);
	
	public AccountInfoDto getUserInfo(String token);

    
}
