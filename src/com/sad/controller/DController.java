package com.sad.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sad.dao.AnswerDaoImpl;
import com.sad.dao.PersonsDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.Persons;
import com.sad.dto.Question;

@Controller
public class DController {

	@RequestMapping("/deantetest")
	public ModelAndView index(Model model) {
			
			Persons personDto = new Persons(0,"DeAnte","Firmin","deantedfirmin@gmail.com","Clinton Twp",1);
			PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
			newPersonDao.addPersons(personDto);
			
			
			
			Answer answerDto = new Answer(0,1,1,1, null, null, null);
			AnswerDaoImpl newAnswerDao = new AnswerDaoImpl();
			newAnswerDao.addAnswer(answerDto);
			
			

			return new ModelAndView("deantetest");
		}
	@RequestMapping("/studenttest")
	public ModelAndView studentTest(Model model) {
		
		//Persons personDto = new Persons(0,"DeAnte","Firmin","deantedfirmin@gmail.com","Clinton Twp",1);
		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		//newPersonDao.addPersons(personDto);
		ArrayList<Persons> list = newPersonDao.getAllPersons();
		
		//System.out.println(list);

		return new ModelAndView("studenttest","list",list);
	}
	
	 @RequestMapping(value = "/deleteperson", method = RequestMethod.GET)
	public ModelAndView deletePerson(Model model, @RequestParam("id") int id) {
		Persons person = new Persons();
		person.setPersonID(id);
		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		
		newPersonDao.deletePersons(person);
		ArrayList<Persons> list = newPersonDao.getAllPersons();
		return new ModelAndView("studenttest","list",list);
	}
	//takes you to addupdate person page
		 @RequestMapping("/addupdateperson")
			public ModelAndView updatePersonPage(Model model,HttpServletRequest request) {
			 int id = Integer.parseInt(request.getParameter("id"));
			 String firstName = request.getParameter("firstname");
			 
			 model.addAttribute("updatePersonTitle", "<h>Update Person</h>");
			 model.addAttribute("updatePersonAction", "<form action=\"updatestudentform\" method=\"post\">");
			 model.addAttribute("personID", id);
			 model.addAttribute("updatePersonButton", "<input type=\"submit\" value=\"Update Person\">");
				return new ModelAndView("addupdateperson");
			}
		 //update person form
	 @RequestMapping(value = "/updatestudentform", method = RequestMethod.POST)
		public ModelAndView updatePerson(Model model,HttpServletRequest request) {
		 	int id = Integer.parseInt(request.getParameter("id"));
		 	String firstName = request.getParameter("firstname");
		 	String lastName = request.getParameter("lastname");
		 	String email = request.getParameter("email");
		 	String location = request.getParameter("location");
		 	int cohortID = Integer.parseInt((request.getParameter("cohortid")));
		 
		 
		 
		 	Persons person = new Persons(id,firstName,lastName,email,location,cohortID);
			
			PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
			newPersonDao.updatePersons(person);
			
			ArrayList<Persons> list = newPersonDao.getAllPersons();

			return new ModelAndView("studenttest","list",list);
		}
	
	 
	//takes you to addupdate person page
	 @RequestMapping("/addperson")
	 public ModelAndView addPersonPage(Model model) {
		 model.addAttribute("addPersonTitle", "<h>Add Person</h>");
		 model.addAttribute("addPersonAction", "<form action=\"addstudentform\" method=\"post\">");
		 model.addAttribute("addPersonButton", "<input type=\"submit\" value=\"Add Person\">");
		 return new ModelAndView("addupdateperson");
		 
		 
	 }
	//add person form
	 @RequestMapping(value = "/addstudentform", method = RequestMethod.POST)
	 public ModelAndView addPerson(Model model, HttpServletRequest request) {
		 String firstName = request.getParameter("firstname");
		 String lastName = request.getParameter("lastname");
		 String email = request.getParameter("email");
		 String location = request.getParameter("location");
		 int cohortID = Integer.parseInt((request.getParameter("cohortid")));
		 model.addAttribute("addPersonButton", "<input type=\"submit\" value=\"Add Person\">");
		 Persons personDto = new Persons(0,firstName,lastName,email,location,cohortID);
		 PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		 newPersonDao.addPersons(personDto);
		 
		 ArrayList<Persons> list = newPersonDao.getAllPersons();
		 
		 return new ModelAndView("studenttest","list",list);
	
	}
//		@RequestMapping("/submitprofile")
//		public ModelAndView test2(@RequestParam ("firstName") String name) {
//			Persons personDto = new Persons(name);
//			PersonsDaoImpl personDao = new PersonsDaoImpl();
//			
//			personDao.addPersons(personDto);
//			
//			return new ModelAndView("deantetest");
//			
	//
	 }

