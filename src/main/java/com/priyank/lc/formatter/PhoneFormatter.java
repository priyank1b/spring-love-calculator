package com.priyank.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.priyank.lc.api.PhoneDto;

public class PhoneFormatter implements Formatter<PhoneDto>{
	
	
	public PhoneFormatter() {
		
		System.out.println("Inside PhoneFormatter constructer");
		// TODO Auto-generated constructor stub
	}


	//print method is called when ever data is to be shown to the client
	@Override
	public String print(PhoneDto phone, Locale locale) {
		
		return null;
	}

	
	//parse method is called when ever data is getting fetched from the client 
	@Override
	public PhoneDto parse(String completePhoneNumber, Locale locale) throws ParseException {
		
		int index = completePhoneNumber.indexOf("-");
		String[] phoneArr = completePhoneNumber.split("-");
		PhoneDto phone = new PhoneDto();
		
		if(index == -1 || completePhoneNumber.startsWith("-")) {
			phone.setCountryCode("91");
			if(phoneArr.length==0) {
				phone.setPhoneNumber("1234567890");
			}else if(completePhoneNumber.startsWith("-")){
				phone.setPhoneNumber(phoneArr[1]);
			}else {
				phone.setPhoneNumber(phoneArr[0]);
			}
			
		}else {
			phone.setCountryCode(phoneArr[0]);
			if(phoneArr.length<2) {
				phone.setPhoneNumber("1234567890");
			}else {
				phone.setPhoneNumber(phoneArr[1]);
			}
			
		}
		
		
		return phone;
	}

}
