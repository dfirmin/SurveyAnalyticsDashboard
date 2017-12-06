package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Cohort;
import com.sad.dto.Offered_Answer;

public class Offered_AnswerDaoImpl implements Offered_AnswerDao {

	@Override
	public ArrayList<Offered_Answer> getAllOffered_Answer() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Offered_Answer.class);
		ArrayList<Offered_Answer> list = (ArrayList<Offered_Answer>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateOffered_Answer(Offered_Answer offeredanswer) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.update(offeredanswer); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteOffered_Answer(Offered_Answer offeredAnswer) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session session = sessionFact.openSession();

		session.beginTransaction();

		session.delete(offeredAnswer); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addOffered_Answer(Offered_Answer newOfferedAnswer) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(newOfferedAnswer);
		tx.commit();
		session.close();

	}

}
