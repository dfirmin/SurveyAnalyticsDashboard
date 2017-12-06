package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Survey_QA;
import com.sad.dto.Survey_Question;

public class Survey_QuestionsDaoImpl implements Survey_QuestionsDao {

	@Override
	public ArrayList<Survey_Question> getAllSurvey_QuestionsDaos() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Survey_Question.class);
		ArrayList<Survey_Question> list = (ArrayList<Survey_Question>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateSurvey_QuestionsDao(Survey_Question surveyquestion) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.update(surveyquestion); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteSurvey_QuestionsDao(Survey_Question surveyquestion) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session session = sessionFact.openSession();

		session.beginTransaction();

		session.delete(surveyquestion); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addSurvey_QuestionsDao(Survey_Question newSurveyQuestion) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newSurveyQuestion);
		tx.commit();
		session.close();

	}

}
