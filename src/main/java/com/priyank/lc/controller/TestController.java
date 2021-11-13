package com.priyank.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	//commenting below annotation because we are not returning any string we are returning a web page which will be configured using view resolver.
	//@ResponseBody 
	@RequestMapping("/test")
	public String test() {
		return "hello-world";//return the view jsp or any other file which need to be displayed on the web page and which is there in view folder.
	}
}
