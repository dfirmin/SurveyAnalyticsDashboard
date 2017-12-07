package com.sad.controller;

import java.util.ArrayList;

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
		
		Persons personDto = new Persons(0,"DeAnte","Firmin","deantedfirmin@gmail.com","Clinton Twp",1);
		PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
		newPersonDao.addPersons(personDto);
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

		return new ModelAndView("studenttest");
	}
	 
	 @RequestMapping(value = "/updateperson", method = RequestMethod.GET)
		public ModelAndView updatePerson(Model model, @RequestParam("id") int id) {
			Persons person = new Persons();
			person.setPersonID(id);
			PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
			newPersonDao.updatePersons(person);

			return new ModelAndView("studenttest");
		}
	
//	@RequestMapping("/submitprofile")
//	public ModelAndView test2(@RequestParam ("firstName") String name) {
//		Persons personDto = new Persons(name);
//		PersonsDaoImpl personDao = new PersonsDaoImpl();
//		
//		personDao.addPersons(personDto);
//		
//		return new ModelAndView("deantetest");
//		
//	}

}
