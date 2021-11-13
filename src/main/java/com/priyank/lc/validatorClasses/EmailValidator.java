package com.priyank.lc.validatorClasses;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.priyank.lc.api.UserRegistrationDto;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDto.email", "error.length.email.blank");
		
		String email = ((UserRegistrationDto)object).getCommunicationDto().getEmail();
		if(!email.contains("@")) {
			errors.rejectValue("communicationDto.email", "error.length.email.syntax");
		}
	}

}
