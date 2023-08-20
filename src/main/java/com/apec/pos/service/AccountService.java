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
import com.apec.pos.Dto.copy.accountDto.RegisterRequest;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.RoleEntity;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.service.serviceInterface.AccountInterface;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
			return new LoginResponDto(aEntity.getRoles(),jwtService.generateToken(aEntity),aEntity.getSdt(),aEntity.getAccountName(),aEntity.getImgUser(),aEntity.getUsername());
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
	    accountEntity2.setImgUser("https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg");
	    // Lưu tài khoản mới vào cơ sở dữ liệu
	    accountRepository.insert(accountEntity2);
	    
	    LoginResponDto loginResponDto =new LoginResponDto(accountEntity2.getId(),accountEntity2.getRoles(),jwtService.generateToken(accountEntity2),accountEntity2.getSdt(),accountEntity2.getAccountName(),accountEntity2.getImgUser(),accountEntity2.getUsername());;
	    
	    return loginResponDto;
	}



		@Override
		public AccountInfoDto getUserInfo(String token) {
		String username= jwtService.getUsernameFromToken(token);
		AccountEntity accountEntity = accountRepository.findByUsername(username);
		AccountInfoDto accountInfoDto = new AccountInfoDto(accountEntity.getAccountName(),accountEntity.getSdt(),accountEntity.getUsername());
		
		return accountInfoDto;
	}

		@Override
		public LoginResponDto addEmployee(RegisterRequest registerRequest) {
			Set<RoleEntity> roleEntity = new HashSet<>();
			    RoleEntity userRole = new RoleEntity();
			    userRole.setAuthority("EMPLOYEE");
			    userRole.setId(3);
			    roleEntity.add(userRole);
			AccountEntity accountEntity = new AccountEntity();
				accountEntity.setAccountName(registerRequest.getAccountName());
				accountEntity.setImgUser(registerRequest.getImgUser());
				accountEntity.setUsername(registerRequest.getUsername());
				accountEntity.setPassword(registerRequest.getPassword());
				accountEntity.setSdt(registerRequest.getSdt());
				accountEntity.setRoles(roleEntity);
			accountEntity= accountRepository.insert(accountEntity);
			
			LoginResponDto loginResponDto = new LoginResponDto();
					loginResponDto.setAccountName(registerRequest.getAccountName());
					loginResponDto.setId(accountEntity.getId());
					loginResponDto.setImgUser(registerRequest.getImgUser());
					loginResponDto.setMsv(registerRequest.getUsername());
					loginResponDto.setToken(jwtService.generateToken(accountEntity));
					loginResponDto.setStd(registerRequest.getSdt());
			return loginResponDto;
		}

		@Override
		public AccountInfoDto updateAccountInfo(RegisterRequest updateRequest) throws Exception {
			AccountEntity accountEntity = accountRepository.findByUsername(updateRequest.getUsername());
			System.out.println(updateRequest.getPassword());
			if (accountEntity==null) {
				 return null;
			}
			if(passwordEncoder.matches(updateRequest.getPassword(), accountEntity.getPassword())) {
				if(updateRequest.getAccountName()!=null) accountEntity.setAccountName(updateRequest.getAccountName());
				if(updateRequest.getImgUser()!=null) accountEntity.setImgUser(updateRequest.getImgUser());
				accountEntity= accountRepository.update(accountEntity);
				
				AccountInfoDto accountInfoDto = new AccountInfoDto(accountEntity.getAccountName(),accountEntity.getSdt(),accountEntity.getUsername());		
				return accountInfoDto;
			}
			return null;
		}

}
