package com.sad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sad.dao.AnswerDaoImpl;
import com.sad.dao.CohortDaoImpl;
import com.sad.dao.PersonsDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.Cohort;
import com.sad.dto.Persons;
import com.sad.dto.Question;

@Controller
public class DController {

	@RequestMapping("/deantetest")
	public ModelAndView index(Model model) {

		Persons personDto = new Persons(0, "DeAnte", "Firmin", "deantedfirmin@gmail.com", "Clinton Twp", 1);
		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		newPersonDao.addPersons(personDto);

		Answer answerDto = new Answer(0, 1, 1, 1, null, null, null);
		AnswerDaoImpl newAnswerDao = new AnswerDaoImpl();
		newAnswerDao.addAnswer(answerDto);

		return new ModelAndView("deantetest");
	}

	@RequestMapping("/student")
	public ModelAndView studentTest(Model model) {

		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		ArrayList<Persons> list = newPersonDao.getAllPersons();
		// Populate dropdown list
		cohortDropDownList(model);

		return new ModelAndView("student", "list", list);
	}

	@RequestMapping(value = "/deleteperson", method = RequestMethod.GET)
	public ModelAndView deletePerson(Model model, @RequestParam("id") int id) {
		Persons person = new Persons();
		person.setPersonID(id);
		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();

		newPersonDao.deletePersons(person);
		ArrayList<Persons> list = newPersonDao.getAllPersons();
		return new ModelAndView("student", "list", list);
	}

	// takes you to addupdate person page
	@RequestMapping("/addupdateperson")
	public ModelAndView updatePersonPage(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");

		model.addAttribute("updatePersonTitle", "<h>Update Person</h>");
		model.addAttribute("updatePersonAction", "<form action=\"updatestudentform\" method=\"post\">");
		model.addAttribute("personID", id);
		model.addAttribute("updatePersonButton", "<input type=\"submit\" value=\"Update Person\">");
		return new ModelAndView("addupdateperson");
	}

	// update person form
	@RequestMapping(value = "/updatestudentform", method = RequestMethod.POST)
	public ModelAndView updatePerson(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		int cohortID = Integer.parseInt((request.getParameter("cohortid")));

		Persons person = new Persons(id, firstName, lastName, email, location, cohortID);

		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		newPersonDao.updatePersons(person);

		ArrayList<Persons> list = newPersonDao.getAllPersons();

		return new ModelAndView("student", "list", list);
	}

	// takes you to addupdate person page
	@RequestMapping("/addperson")
	public ModelAndView addPersonPage(Model model) {
		model.addAttribute("addPersonTitle", "<h>Add Person</h>");
		model.addAttribute("addPersonAction", "<form action=\"addstudentform\" method=\"post\">");
		model.addAttribute("addPersonButton", "<input type=\"submit\" value=\"Add Person\">");
		return new ModelAndView("addupdateperson");

	}

	// add person form
	@RequestMapping(value = "/addstudentform", method = RequestMethod.POST)
	public ModelAndView addPerson(Model model, HttpServletRequest request) {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		int cohortID = Integer.parseInt((request.getParameter("cohortid")));
		model.addAttribute("addPersonButton", "<input type=\"submit\" value=\"Add Person\">");
		Persons personDto = new Persons(0, firstName, lastName, email, location, cohortID);
		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		newPersonDao.addPersons(personDto);

		ArrayList<Persons> list = newPersonDao.getAllPersons();

		return new ModelAndView("student", "list", list);

	}

	@RequestMapping("/thedashboard")
	public ModelAndView dashboardIndex() {

		return new ModelAndView("thedashboard");
	}

	public ModelAndView cohortDropDownList(Model model) {
		Cohort cohortDto = new Cohort();
		CohortDaoImpl cohortDao = new CohortDaoImpl();
		ArrayList<Cohort> cohortList = cohortDao.getAllCohorts();

		model.addAttribute("listcohorts", cohortList);

		// Configuration config = new Configuration().configure("hibernate.cfg.xml");
		//
		// SessionFactory sessionFactory = config.buildSessionFactory();
		//
		// Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		// SQLQuery sql = session.createSQLQuery("SELECT FirstName, LastName, Email,
		// Location, CohortName, CohortSemester FROM Persons\n" +
		// "INNER JOIN Cohort\n" +
		// "ON Cohort.CohortID = Persons.CohortID;");
		// List<Object> fullList = sql.list();
		// model.addAttribute("pcohortList", fullList);
		return new ModelAndView("student");

	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView dropDownList(Model model, HttpServletRequest request) {
		cohortDropDownList(model);
		String selection = request.getParameter("cohort");
		System.out.println(selection);
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit;
		ArrayList<Persons> list = null;
		if (selection.equalsIgnoreCase("Java")) {
			crit = session.createCriteria(Persons.class);
			crit.add(Restrictions.eq("cohortID", 1));
			list = (ArrayList<Persons>) crit.list();
		}

		if (selection.equalsIgnoreCase(".Net")) {
			crit = session.createCriteria(Persons.class);
			crit.add(Restrictions.eq("cohortID", 2));
			list = (ArrayList<Persons>) crit.list();
		}

		if (selection.equalsIgnoreCase("FrontEnd")) {
			crit = session.createCriteria(Persons.class);
			crit.add(Restrictions.eq("cohortID", 3));
			list = (ArrayList<Persons>) crit.list();

		}

		if (selection.equalsIgnoreCase("All")) {
			PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
			list = newPersonDao.getAllPersons();

		}

		tx.commit();
		session.close();
		return new ModelAndView("student", "list", list);

	}
	
	@RequestMapping("/newdash")
	public String exampleQuery(Model model) {
				 Configuration config = new Configuration().configure("hibernate.cfg.xml");
				
				 SessionFactory sessionFactory = config.buildSessionFactory();
				
				 Session session = sessionFactory.openSession();
				 Transaction tx = session.beginTransaction();
				 SQLQuery sql = session.createSQLQuery("SELECT * FROM Answer WHERE QuestionID ");
				 List<Object> fullList = sql.list();
		return "";
	}
}
