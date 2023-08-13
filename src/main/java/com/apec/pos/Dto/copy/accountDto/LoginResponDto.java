package com.apec.pos.Dto.copy.accountDto;

import java.util.Set;

import com.apec.pos.entity.RoleEntity;

public class LoginResponDto {
	private Integer id;
	private Set<RoleEntity> role;
	private String token;
	private String std;
	private String accountName;
	private String imgUser;
	private String msv;
	
	
	
	
	public LoginResponDto(Integer id, Set<RoleEntity> role, String token, String std, String accountName,
			String imgUser, String msv) {
		super();
		this.id = id;
		this.role = role;
		this.token = token;
		this.std = std;
		this.accountName = accountName;
		this.imgUser = imgUser;
		this.msv = msv;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMsv() {
		return msv;
	}
	public LoginResponDto(Set<RoleEntity> role, String token, String std, String accountName, String imgUser,
			String msv) {
		super();
		this.role = role;
		this.token = token;
		this.std = std;
		this.accountName = accountName;
		this.imgUser = imgUser;
		this.msv = msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public LoginResponDto(Set<RoleEntity> role, String token, String std, String accountName, String imgUser) {
		super();
		this.role = role;
		this.token = token;
		this.std = std;
		this.accountName = accountName;
		this.imgUser = imgUser;
	}
	public Set<RoleEntity> getRole() {
		return role;
	}
	public void setRole(Set<RoleEntity> role) {
		this.role = role;
	}	
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getImgUser() {
		return imgUser;
	}
	public void setImgUser(String imgUser) {
		this.imgUser = imgUser;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LoginResponDto(Set<RoleEntity> role, String token) {
		super();
		this.role = role;
		this.token = token;
	}
	public LoginResponDto() {
		super();
	}
	
	
}
