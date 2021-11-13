package com.priyank.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDto {
	
	//parameters from the url should match here with the dto parameters and also set and get methods should have same name other wise spring won't be able to set or get the attributes.
	//example: from url process-homepage?userName=abc&crushName=xyz
	//here userName and crushName should be same in this dto class also.
	@NotBlank(message = "{error.length.yourName.blank}")//@NotBlank and @Size annotation is from https://mvnrepository.com/artifact/javax.validation/validation-api
	@Size(min = 3,max = 15,message = "{error.length.yourName.size}")
	private String yourName;
	
	@NotBlank(message = " * Crush Name should not be left Blank.")
	@Size(min = 3,max = 15,message = " * Crush Name should be between 3 to 15 characters.")
	private String crushName;
	
	@AssertTrue(message = " * Please agree to our condition.")
	private boolean termAndCondition;
	
	public String getYourName() {
		return yourName;
	}
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	@Override
	public String toString() {
		return "UserInfoDto [userName=" + yourName + ", crushName=" + crushName + "]";
	}


}
