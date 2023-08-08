package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.copy.AccountInfoDto;
import com.apec.pos.Dto.copy.LoginResponDto;
import com.apec.pos.entity.AccountEntity;

public interface AccountInterface {

	public LoginResponDto login(AccountEntity accountEntity);
	
	public LoginResponDto register(AccountEntity accountEntity);
	
	public AccountInfoDto getUserInfo(String token);
}
