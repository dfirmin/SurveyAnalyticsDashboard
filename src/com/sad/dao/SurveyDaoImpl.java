package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Survey;
import com.sad.dto.Survey_Question;
import com.sad.util.HibernateUtil;

public class SurveyDaoImpl implements SurveyDao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public ArrayList<Survey> getAllSurveys() {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Survey.class);
		ArrayList<Survey> list = (ArrayList<Survey>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateSurvey(Survey survey) {
		

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(survey); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteSurvey(Survey survey) {
		

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(survey); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addSurvey(Survey newSurvey) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newSurvey);
		tx.commit();
		session.close();

	}

}
