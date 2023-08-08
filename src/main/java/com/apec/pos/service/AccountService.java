package com.apec.pos.service;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.AccountInfoDto;
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
	public String login(AccountEntity accountEntity) {
		AccountEntity aEntity = accountRepository.findByUsername(accountEntity.getUsername());
		if(aEntity==null) {
			return null;
		}
		if (passwordEncoder.matches( accountEntity.getPassword(),aEntity.getPassword())) {
			return jwtService.generateToken(aEntity);
		}		
		return null;
	}

	@Override
	public String register(AccountEntity accountEntity) {
		// Kiểm tra xem tài khoản đã tồn tại chưa
	    if (accountRepository.findByUsername(accountEntity.getUsername()) != null) {	 
	        return null;
	    }
	    if (accountEntity.getUsername().contains("admin")) {
	        Set<RoleEntity> roleEntity = new HashSet<>();
		    RoleEntity userRole = new RoleEntity();
		    userRole.setAuthority("ADMIN");
		    userRole.setId(1);
		    roleEntity.add(userRole);

		    AccountEntity accountEntity3 = new AccountEntity();
		    accountEntity3.setAccountName(accountEntity.getAccountName());
		    accountEntity3.setCreateDate(new Date());
		    accountEntity3.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
		    accountEntity3.setRoles(roleEntity);
		    accountEntity3.setSdt(accountEntity.getSdt());
		    accountEntity3.setUsername(accountEntity.getUsername());
		    // Lưu tài khoản mới vào cơ sở dữ liệu
		    accountRepository.insert(accountEntity3);
		    
		    return jwtService.generateToken(accountEntity3);
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
	    
	    return jwtService.generateToken(accountEntity2);
	}



		@Override
		public AccountInfoDto getUserInfo(String token) {
		String username= jwtService.getUsernameFromToken(token);
		AccountEntity accountEntity = accountRepository.findByUsername(username);
		AccountInfoDto accountInfoDto = new AccountInfoDto(accountEntity.getAccountName(),accountEntity.getSdt(),accountEntity.getUsername());
		
		return accountInfoDto;
	}

}
