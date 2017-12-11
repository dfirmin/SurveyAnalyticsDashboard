package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.sad.dto.Results;

public class ResultsDaoImpl implements ResultsDao {

	@Override
	public ArrayList<Results> getAllResults() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		 * private int answerid;
			private int personid;
			private String firstname;
			private String lastname;
			private String cohortname;
			private int questionid;
			private int surveyid;
			private String userresponse;
			private String watsonresponse;
		 */
		
		String hql = 
				"SELECT t1.AnswerID as AnswerID,  \n" + 
				"				t1.PersonID as PersonID,  \n" + 
				"				t1.QuestionID as QuestionID,  \n" + 
				"				t1.FirstName as FirstName,  \n" + 
				"				t1.LastName as LastName,   \n" + 
				"				t1.SurveyID as SurveyID,   \n" + 
				"				t1.UserResponse as UserResponse,  \n" + 
				"				t1.WatsonResponse as WatsonResponse, \n" + 
				"				t1.SubmitDate as SubmitDate,  \n" + 
				"				MikeDB.Cohort.CohortName as CohortName  \n" + 
				"				FROM  \n" + 
				"					(SELECT MikeDB.Answer.*, \n" + 
				"						MikeDB.Persons.FirstName as FirstName,  \n" + 
				"						MikeDB.Persons.LastName as LastName,  \n" + 
				"						MikeDB.Persons.CohortID as CohortID \n" + 
				"						FROM MikeDB.Answer LEFT JOIN MikeDB.Persons on\n" + 
				"						MikeDB.Answer.PersonID = MikeDB.Persons.PersonID  \n" + 
				"					 ) as t1 \n" + 
				"				LEFT JOIN MikeDB.Cohort on t1.CohortID = MikeDB.Cohort.CohortID;";
		
		Query q = session.createSQLQuery(hql).addEntity(Results.class);
		ArrayList<Results> list = (ArrayList<Results>) q.list();
		tx.commit();
		session.close();
		return list;

	}

}
