package com.sad.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Statement;
import com.sad.dao.AnswerDaoImpl;
import com.sad.dao.CohortDaoImpl;
import com.sad.dao.PersonsDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.Cohort;
import com.sad.dto.Persons;
import com.sad.dto.Question;
import com.sad.dto.SurveyQADto;
import com.sad.util.HibernateUtil;

@Controller
public class DController {
	

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
		cohortDropDownList(model);
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
		// Populate dropdown list
		cohortDropDownList(model);

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
//		Cohort cohortDto = new Cohort();
//		CohortDaoImpl cohortDao = new CohortDaoImpl();
//		ArrayList<Cohort> cohortList = cohortDao.getAllCohorts();
//		model.addAttribute("listcohorts", cohortList);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Cohort.class);
		Projection projection = Projections.distinct(Projections.property("cohortName"));
        crit.setProjection(projection);
        ArrayList<Cohort> cohortList = (ArrayList<Cohort>) crit.list();
        
        	model.addAttribute("listcohorts", cohortList);

		
		return new ModelAndView("student");

	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView dropDownList(Model model, HttpServletRequest request) {
		cohortDropDownList(model);
		String selection = request.getParameter("cohort");
		System.out.println(selection);
//		Configuration config = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = config.buildSessionFactory();
//		Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
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

	public static void emotionChart(Model model) throws ClassNotFoundException {
		String myDriver = "com.mysql.jdbc.Driver";
		Class.forName(myDriver);
		Connection conn = null;
		try {

			conn = DriverManager.getConnection("jdbc:mysql://surveydb.cukvcoyfuo0c.us-east-2.rds.amazonaws.com/MikeDB",
					"survey", "Surveydatabase01");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query1 = ("SELECT SUM(NumberofStudents) AS Sum FROM(SELECT WatsonResponse, COUNT(*) AS NumberofStudents\n"
				+ "FROM Answer\n" + "WHERE QuestionID = 25 && SurveyID = 1\n" + "GROUP BY WatsonResponse) As T;");
		String query2 = ("SELECT WatsonResponse, COUNT(*) AS NumberofStudents\n" + "FROM Answer\n"
				+ "WHERE QuestionID = 25 && SurveyID = 1\n" + "GROUP BY WatsonResponse;");
		// create the java statement
		Statement st = null;
		try {
			st = (Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// execute the query, and get a java resultset
		try {
			ResultSet rs1 = st.executeQuery(query1);
			int sum = 0;
			while (rs1.next()) {
				sum += rs1.getInt("Sum");
			}
			System.out.println("The sum is " + sum);
			ResultSet rs2 = st.executeQuery(query2);
			String googlechart = "[['Emotion', 'Number of Students']";
			while (rs2.next()) {
				String watsonResponse = rs2.getString("WatsonResponse");
				int numberOfStudents = rs2.getInt("NumberofStudents");
				double avg = (double) numberOfStudents / sum;
				double percentage = avg * 100;
				System.out.println("The average is " + avg);
				System.out.println("The percentage is " + percentage);
				googlechart += ",['" + watsonResponse + "'," + percentage + "]";

			}
			googlechart += "]";
			System.out.println(googlechart);

			model.addAttribute("chartData", googlechart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/modifySurvey")
	public String modifySurveyPage(Model model) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// sql query to pull survey questions and answers
		Query query = session.createSQLQuery(
				"SELECT survey_qaid,Question.QuestionID, QuestionText, QuestionType, Offered_Answer.OfferedAnswerID, AnswerText, IsCustom FROM Question "
						+ "inner JOIN Survey_QA " + "ON Question.QuestionID = Survey_QA.QuestionID "
						+ "inner JOIN Offered_Answer "
						+ "ON Offered_Answer.OfferedAnswerID = Survey_QA.OfferedAnswerID "
						+ "WHERE Survey_QA.SurveyID =" + 1 + " Order by questionid,  survey_qaid, OfferedAnswerID ;"
						+ "")
				.addEntity(SurveyQADto.class);
		List<SurveyQADto> results = (List<SurveyQADto>) query.list();
		model.addAttribute("surveyQuestions", results);
		return "modifySurvey";
	}

}
