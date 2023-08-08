package com.apec.pos.service;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.accountDto.AccountInfoDto;
import com.apec.pos.Dto.copy.accountDto.LoginRequest;
import com.apec.pos.Dto.copy.accountDto.LoginResponDto;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.RoleEntity;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.service.serviceInterface.AccountInterface;

@Service
@CacheConfig(cacheNames = "iotFood")
public class AccountService extends BaseService<AccountRepository, AccountEntity, Integer> implements AccountInterface{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	AccountRepository getRepository() {
		// TODO Auto-generated method stub
		return accountRepository;
	}

	@Override
	public LoginResponDto login(LoginRequest loginRequest) {
		AccountEntity aEntity = accountRepository.findByUsername(loginRequest.getUsername());
		if(aEntity==null) {
			return null;
		}
		if (passwordEncoder.matches( loginRequest.getPassword(),aEntity.getPassword())) {
			return new LoginResponDto(aEntity.getRoles(),jwtService.generateToken(aEntity));
		}		
		return null;
	}

	@Override
	public LoginResponDto register(AccountEntity accountEntity) {
		// Kiểm tra xem tài khoản đã tồn tại chưa
	    if (accountRepository.findByUsername(accountEntity.getUsername()) != null) {	 
	        return null;
	    }
	   

	    // Tài khoản chưa tồn tại, tạo một tài khoản mới với vai trò "USER"
	    Set<RoleEntity> roleEntity = new HashSet<>();
	    RoleEntity userRole = new RoleEntity();
	    userRole.setAuthority("USER");
	    userRole.setId(2);
	    roleEntity.add(userRole);

	    AccountEntity accountEntity2 = new AccountEntity();
	    accountEntity2.setAccountName(accountEntity.getAccountName());
	    accountEntity2.setCreateDate(new Date());
	    accountEntity2.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
	    accountEntity2.setRoles(roleEntity);
	    accountEntity2.setSdt(accountEntity.getSdt());
	    accountEntity2.setUsername(accountEntity.getUsername());
	    // Lưu tài khoản mới vào cơ sở dữ liệu
	    accountRepository.insert(accountEntity2);
	    
	    LoginResponDto loginResponDto =new LoginResponDto(accountEntity2.getRoles(),jwtService.generateToken(accountEntity2));
	    
	    return loginResponDto;
	}



		@Override
		public AccountInfoDto getUserInfo(String token) {
		String username= jwtService.getUsernameFromToken(token);
		AccountEntity accountEntity = accountRepository.findByUsername(username);
		AccountInfoDto accountInfoDto = new AccountInfoDto(accountEntity.getAccountName(),accountEntity.getSdt(),accountEntity.getUsername());
		
		return accountInfoDto;
	}

}
