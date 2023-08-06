package com.apec.pos.entity;

import java.util.Collection;


import java.util.Date;
import java.util.Set;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class AccountEntity  extends BaseEntity implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String sdt;
	
	private String accountName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name="user_role",
	        joinColumns = {@JoinColumn(name="user_id")},
	        inverseJoinColumns = {@JoinColumn(name="role_id")}
	    )
	@JsonIgnore
	private Set<RoleEntity> roles;
	
	
	
	public AccountEntity(String createBy, String modifiedBy, Integer id, String username, String password, String sdt,
			String accountName, Date createDate, Date modifyDate, Set<RoleEntity> roles) {
		super(createBy, modifiedBy);
		this.id = id;
		this.username = username;
		this.password = password;
		this.sdt = sdt;
		this.accountName = accountName;
		this.roles = roles;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}
	
	public AccountEntity() {
		
	}
	
	public AccountEntity(String createBy, String modifiedBy) {
		super(createBy, modifiedBy);
	}

	public AccountEntity(String createBy, String modifiedBy, Integer id, String username, String password, String sdt,
			String accountName, Set<RoleEntity> roles) {
		super(createBy, modifiedBy);
		this.id = id;
		this.username = username;
		this.password = password;
		this.sdt = sdt;
		this.accountName = accountName;
		this.roles = roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
