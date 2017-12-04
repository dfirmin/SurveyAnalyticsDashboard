package com.sad.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class SiddiqueController {

	@RequestMapping("/survey") 
	public String survey() {
	
	return "survey";
}
	
	
}
