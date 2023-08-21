package com.apec.pos.Dto.copy.accountDto;

import java.util.List;

public class AccountResponseAdmin {

	private Integer totalRow;
	private List<LoginResponDto> loginResponDtos;
	
	public Integer getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}
	public List<LoginResponDto> getLoginResponDtos() {
		return loginResponDtos;
	}
	public void setLoginResponDtos(List<LoginResponDto> loginResponDtos) {
		this.loginResponDtos = loginResponDtos;
	}
	
	
}
