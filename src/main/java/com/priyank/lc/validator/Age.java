package com.priyank.lc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.priyank.lc.validatorClasses.AgeValidation;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidation.class)
public @interface Age {
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String message() default "Age should be between 18 to 60";

	int min() default 18;

	int max() default 60;

}
