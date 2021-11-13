package com.priyank.lc.api;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

import com.priyank.lc.validator.Age;

public class UserRegistrationDto {

	public UserRegistrationDto() {
		System.out.println("inside UserRegistrationDto");
		// TODO Auto-generated constructor stub
	}
	
	@NotEmpty(message = "* Name cannot be empty")
	private String user;
	private String userName;
	private char[] pass;
	private String country;
	private String[] hobbies;
	private String gender;
	@Age
	private Integer age;
	
	private CommunicationDto communicationDto;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPass() {
		return pass;
	}
	public void setPass(char[] pass) {
		this.pass = pass;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public CommunicationDto getCommunicationDto() {
		return communicationDto;
	}
	public void setCommunicationDto(CommunicationDto communicationDto) {
		this.communicationDto = communicationDto;
	}
	@Override
	public String toString() {
		return "UserRegistrationDto [user=" + user + ", userName=" + userName + ", pass=" + Arrays.toString(pass)
				+ ", country=" + country + ", hobbies=" + Arrays.toString(hobbies) + ", gender=" + gender + "]";
	}
}
