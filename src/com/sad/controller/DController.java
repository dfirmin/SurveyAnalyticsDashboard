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
		
		

			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			/*
			 * The SessionFactory is a factory of session and client of Connection Provider.
			 * It holds second level cache (optional) of data
			 */
			SessionFactory sessionFactory = config.buildSessionFactory();
			/*
			 * A Session is used to get a physical connection with a database. The Session
			 * object is lightweight and designed to be instantiated each time an
			 * interaction is needed with the database. Persistent objects are saved and
			 * retrieved through a Session object.
			 * 
			 * The session objects should not be kept open for a long time because they are
			 * not usually thread safe and they should be created and destroyed them as
			 * needed. The main function of the Session is to offer, create, read, and
			 * delete operations for instances of mapped entity classes.
			 */
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria crit = session.createCriteria(Question.class); // the strikethrough indicates this is deprecated
			ArrayList<Question> list = (ArrayList<Question>) crit.list();
			System.out.println(list);
			tx.commit();
			session.close();
			
			Persons personDto = new Persons(0,"DeAnte","Firmin","deantedfirmin@gmail.com","Clinton Twp",1);
			PersonsDaoImpl newPersonDao = new PersonsDaoImpl();
			
			newPersonDao.addPersons(personDto);
			
			
			
			Answer answerDto = new Answer(0,1,1,1);
			AnswerDaoImpl newAnswerDao = new AnswerDaoImpl();
			newAnswerDao.addAnswer(newAnswer);
			
			

			return new ModelAndView("deantetest");
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
