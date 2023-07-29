package com.apec.pos.Dto.copy;

public class AccountInfoDto {
	private String accountName;
	private String std;
	private String username;
	
	public AccountInfoDto(String accountName, String std, String username) {
		super();
		this.accountName = accountName;
		this.std = std;
		this.username = username;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
