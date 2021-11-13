package com.priyank.lc.validatorClasses;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.priyank.lc.validator.Age;

@Component
public class AgeValidation implements ConstraintValidator<Age, Integer>{

	private int min;
	private int max;
	
	//initializing age input given by user in the form in min instance declared above.
	@Override
	public void initialize(Age age) {
		this.min=age.min();
		this.max=age.max();
	}
	
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if(age == null) {
			return false;
		}
		if(age < min || age > max) {
			return false;
		}
		return true;
	}

}
