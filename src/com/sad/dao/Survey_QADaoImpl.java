package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Question;
import com.sad.dto.Survey_QA;
import com.sad.util.HibernateUtil;

public class Survey_QADaoImpl implements Survey_QADao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public ArrayList<Survey_QA> getAllSurvey_QA() {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Survey_QA.class);
		ArrayList<Survey_QA> list = (ArrayList<Survey_QA>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateSurvey_QA(Survey_QA surveyqa) {
		

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(surveyqa); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table
		
	}

	@Override
	public void deleteSurvey_QA(Survey_QA surveyqa) {
	

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(surveyqa); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();
		
	}

	@Override
	public void addSurvey_QA(Survey_QA newSurveyQA) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newSurveyQA);
		tx.commit();
		session.close();
		
	}

}
