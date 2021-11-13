package com.priyank.lc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyank.lc.api.UserRegistrationDto;
import com.priyank.lc.propertyeditor.NamePropertyEditor;
import com.priyank.lc.validatorClasses.EmailValidator;
import com.priyank.lc.validatorClasses.UserNameValidator;

@Controller
public class RegistrationController {

	@Autowired
	private EmailValidator emailValidate;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("registerUser") UserRegistrationDto userRegistrationDto) {
		return "registration-page";
	}
	
	@RequestMapping("/registeredUserDeatils")
	public String showRegisteredUserDeatils(@Valid @ModelAttribute("registerUser") UserRegistrationDto userRegistrationDto, BindingResult result) {
		System.out.println("Inside showRegisteredUserDeatils");
		
		emailValidate.validate(userRegistrationDto, result);
		
		if(result.hasErrors()) {
			return "registration-page";
		}
		
		return "registration-details";
	}
	
	
	
	
	//INIT BINDER GETS CALLED EVERYTIME BEFORE WHEN REGISTER PAGE GETS LOADEDD AS WELL AS WHEN WE CLICK ON REGISTER
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//property binder is used to convert data into obj, spring does using property binder 
		
		//String Trimmer Editor is used to trim whitespaces from the input
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "user", editor);
		
		
		//below method setDisallowedFields is used to allow/disallow fields from the user to take it as an null value even if their is data in the field
		//binder.setDisallowedFields("user");
		
		NamePropertyEditor nameEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "user",nameEditor);
		
		//Their is a formatter, property editor and converter
		//formatter was used in phone formatter
		//below is the way of validating using spring validators. Above validators was using hibernate validator.
		binder.addValidators(new UserNameValidator());
		
		//lets make one more validation using converter
		//converter call needs to be done in configuration file.
		
		//email validation
		//let's make email validator as manual written in above method
		//binder.addValidators(new EmailValidator()); this is one way
	}
}
