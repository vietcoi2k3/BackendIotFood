package com.apec.pos.Dto.copy.otpDto;

public class OtpResponseDto {

	private OtpStatusDto status;
    private String message;
	public OtpStatusDto getStatus() {
		return status;
	}
	public void setStatus(OtpStatusDto status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public OtpResponseDto(OtpStatusDto status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
    
    
    
}
