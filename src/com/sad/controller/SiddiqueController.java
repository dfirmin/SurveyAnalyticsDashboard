package com.sad.controller;

import java.util.ArrayList;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//display the list of classes
	@RequestMapping("/cohort")
	public ModelAndView getAllCohorts(){
		
		CohortDaoImpl dao = new CohortDaoImpl();//TODO replace with factory design pattern here
		
		ArrayList<Cohort> listCohort = dao.getAllCohorts();//valueOf() is a factory design pattern here
			
		
		return new ModelAndView("cohort","cohortID", listCohort);
	}
	
	@RequestMapping("/addCohort") 
	public String addCohort() {
		return "addCohort"; 
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add(@RequestParam("cohortName") String cohortName, @RequestParam("cohortSemester") String cohortSemester) {
		Cohort cohortdto = new Cohort(0,cohortName, cohortSemester);
		CohortDaoImpl dao = new CohortDaoImpl();
		dao.addCohort(cohortdto);
		
		ArrayList<Cohort> listCohort = dao.getAllCohorts();
		return new ModelAndView("cohort", "cohortID", listCohort);
	}
	
	@RequestMapping("updatecohortform") 
	public String updateForm() {
		return "updateCohort";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET) 
	public ModelAndView update(@RequestParam("cohortName") String cohortName, @RequestParam("cohortSemester") String cohortSemester) {
		Cohort cohortdto = new Cohort(0, cohortName, cohortSemester);
		CohortDaoImpl dao = new CohortDaoImpl();
		dao.updateCohort(cohortdto);
		
		ArrayList<Cohort> listCohort = dao.getAllCohorts();
		return new ModelAndView("cohort", "cohortID", listCohort);
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete() {
		
		return new ModelAndView("cohort", "cohortID", "");
	}
	
	
}
