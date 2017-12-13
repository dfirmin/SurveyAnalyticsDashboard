package com.sad.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	//display the list of classes
	@SuppressWarnings("deprecation")
	@RequestMapping("/cohort")
	public ModelAndView getACohort() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria crit = session.createCriteria(Cohort.class);
        //crit.setProjection(Projections.distinct(Projections.property("cohortName")));
        crit.add(Restrictions.eq("cohortName","Java"));
        @SuppressWarnings("unchecked")
		ArrayList<Cohort> list = (ArrayList<Cohort>) crit.list();
        System.out.println(list.get(0).getCohortName() + " " + list.get(1).getCohortName());
        CohortDaoImpl dao = new CohortDaoImpl();
        
        list = dao.getAllCohorts();
        
        return new ModelAndView("cohort", "cohortID", list);
	}
	
	
	// display the list of classes
	/*@RequestMapping("/cohort")
	public ModelAndView getAllCohorts() {

		CohortDaoImpl dao = new CohortDaoImpl();// TODO replace with factory design pattern here

		ArrayList<Cohort> listCohort = dao.getAllCohorts();// valueOf() is a factory design pattern here
		
		return new ModelAndView("cohort", "cohortID", listCohort);
	}*/

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
	public String updateForm(@RequestParam("id") int id, @RequestParam("cohortName") String cohortName, Model model) {
		model.addAttribute("cohortID", id);
		model.addAttribute("cohortName", cohortName);
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria crit = session.createCriteria(Cohort.class);
    
        crit.add(Restrictions.eq("cohortName",cohortName));
        @SuppressWarnings("unchecked")
		ArrayList<Cohort> list = (ArrayList<Cohort>) crit.list();

        model.addAttribute("cohortList", list);

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


