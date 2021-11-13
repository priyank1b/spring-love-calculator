package com.priyank.lc.validatorClasses;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.priyank.lc.api.UserRegistrationDto;

public class UserNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "* User Name cannot be left empty.");
		
		String userName = ((UserRegistrationDto)object).getUserName();
		if(!userName.contains("_")) {
			errors.rejectValue("userName", "userName.invalidString", "* Username should contain _ in it");
		}
	}

}
