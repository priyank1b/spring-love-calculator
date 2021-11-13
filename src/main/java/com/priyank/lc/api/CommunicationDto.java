package com.priyank.lc.api;

public class CommunicationDto {
	
	
	public CommunicationDto() {
		System.out.println("inside CommunicationDto");
		// TODO Auto-generated constructor stub
	}
	private String email;
	private PhoneDto phone;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PhoneDto getPhone() {
		return phone;
	}
	public void setPhone(PhoneDto phone) {
		this.phone = phone;
	}

	
}
