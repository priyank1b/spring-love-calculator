package com.priyank.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.priyank.lc.api.EmailDTO;

@Controller
public class EmailController {

	@RequestMapping("/sendMail")
	public String sendEmail(@ModelAttribute("userEmail") EmailDTO userEmail) {
		return "send-email-page";
	}
	
	@RequestMapping("/processMail")
	public String processEmail(@ModelAttribute("processMail") EmailDTO userEmail) {
		return "process-mail-page";
	}
}
