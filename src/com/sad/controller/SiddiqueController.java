package com.sad.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	public static DateFormat dateConversion(Date dateOne) {
		System.out.println("Time in java.util.Date is : " + dateOne);

		// Date StartDate = convertUtilToSql(dateOne);
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		System.out.println("Using a dateFormat date is : " + df.format(dateOne));

		return df;

	}

	// display the list of classes
	@RequestMapping("/cohort")
	public ModelAndView getAllCohorts() {

		CohortDaoImpl dao = new CohortDaoImpl();// TODO replace with factory design pattern here

		ArrayList<Cohort> listCohort = dao.getAllCohorts();// valueOf() is a factory design pattern here
		
		return new ModelAndView("cohort", "cohortID", listCohort);
	}

	@RequestMapping("/addCohort")
	public String addCohort() {
		return "addCohort";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam("cohortName") String cohortName,
			@RequestParam("cohortSemester") String cohortSemester, @RequestParam("startDate") String StartDate) {

		String[] splitStartDate = StartDate.split("/");
		int year = Integer.parseInt(splitStartDate[2]);
		int month = Integer.parseInt(splitStartDate[0]);
		int day = Integer.parseInt(splitStartDate[1]);
		String formattedDate = year + "/" + month + "/" + day;

		Cohort cohortdto = new Cohort(0, cohortName, cohortSemester, formattedDate);
		CohortDaoImpl dao = new CohortDaoImpl();
		dao.addCohort(cohortdto);

		ArrayList<Cohort> listCohort = dao.getAllCohorts();
		return new ModelAndView("cohort", "cohortID", listCohort);
	}

	@RequestMapping("updatecohortform")
	public String updateForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("cohortID", id);
		return "updateCohort";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") int id, @RequestParam("cohortName") String cohortName,
			@RequestParam("cohortSemester") String cohortSemester, @RequestParam("startDate") String StartDate) {
		String[] splitStartDate = StartDate.split("/");
		int year = Integer.parseInt(splitStartDate[2]);
		int month = Integer.parseInt(splitStartDate[0]);
		int day = Integer.parseInt(splitStartDate[1]);
		String formattedDate = year + "/" + month + "/" + day;

		Cohort cohortdto = new Cohort(id, cohortName, cohortSemester, formattedDate);
		CohortDaoImpl dao = new CohortDaoImpl();
		dao.updateCohort(cohortdto);

		ArrayList<Cohort> listCohort = dao.getAllCohorts();
		return new ModelAndView("cohort", "cohortID", listCohort);
	}

	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView delete (Model model, @RequestParam(value="id") int cohortID) {
		Cohort cohort = new Cohort();
		cohort.setCohortID(cohortID);
		CohortDaoImpl newCohortDao = new CohortDaoImpl();
	
		newCohortDao.deleteCohort(cohort);
		ArrayList<Cohort> listCohort = newCohortDao.getAllCohorts(); 
		return new ModelAndView("cohort", "cohortID", listCohort);

	}

}


