package com.sad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiddiqueController {

	@RequestMapping("/survey") 
	public String survey() {
	
	return "survey";
}
	
	
}
