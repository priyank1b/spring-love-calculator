package com.priyank.lc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.priyank.lc.api.UserInfoDto;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo") UserInfoDto userInfoDto) {
		return "home-page";
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//below is the 1st approach to get data from url using @RequestParam.
	//public String showResultPage(@RequestParam String userName1,@RequestParam String crushName1) {
	
	/*@RequestMapping("/process-homepage")
	//now we have given parameter to @RequestParam annotations, why because the String variable userName1 does not match with home-page name value which is userName.
	//If the request parameters does not match we have to give parameter to @RequestParam("userName")
	//model is used to send data to the result-page it's an interface
	public String showResultPage(@RequestParam("yourName") String userName1,@RequestParam("crushName") String crushName1, Model model) {
		
		model.addAttribute("sendingUserName", userName1);
		model.addAttribute("sendingCrushName", crushName1);
		return "result-page";
	}*/
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//below is the way of using model interface as a parameter in showResultPage and then adding values in model.addAttribute(key,value)
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//rather then given input parameters which is written above make a dto(data transfer object)
	/*@RequestMapping("/process-homepage")
	public String showResultPage(UserInfoDto userInfoDto, Model model) {
		
		//no need setusername and setcrushname spring will do that for us
		//spring will create userinfodto obj and set the values also
		model.addAttribute("userInfo", userInfoDto);
		return "result-page";
	}*/
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//the below maaping of model and userinfodto is same as above from line 36 to 47
	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDto userInfoDto, BindingResult result) {
		if(result.hasErrors()) {
			
			return "home-page"; 
		}
		return "result-page";
	}
}
