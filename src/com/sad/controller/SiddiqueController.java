package com.sad.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sad.dao.CohortDaoImpl;
import com.sad.dto.Cohort;

@Controller
public class SiddiqueController {

	@RequestMapping("/survey") 
	public String survey() {
	
	return "survey";
}
	
	@RequestMapping("/cohort")
	public ModelAndView getAllCohorts(){
		//@RequestParam(required=false, name="cohort") String cohortString
		CohortDaoImpl dao = new CohortDaoImpl();//TODO replace with factory design pattern here
		
		ArrayList<Cohort> listCohort = dao.getAllCohorts();//valueOf() is a factory design pattern here
			
		
		return new ModelAndView("cohort","cohortID", listCohort);
	}

	@RequestMapping("/delete")
	public ModelAndView delete() {
		
		return new ModelAndView("cohort", "cohortID", "");
	}
	
	
}
