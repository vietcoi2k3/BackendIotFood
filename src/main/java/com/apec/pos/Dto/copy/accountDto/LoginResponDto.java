package com.apec.pos.Dto.copy.accountDto;

import java.util.Set;

import com.apec.pos.entity.RoleEntity;

public class LoginResponDto {
	private Set<RoleEntity> role;
	private String token;

	
	
	public Set<RoleEntity> getRole() {
		return role;
	}
	public void setRole(Set<RoleEntity> role) {
		this.role = role;
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
