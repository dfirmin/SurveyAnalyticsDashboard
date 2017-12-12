package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.sad.dto.Answer;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public ArrayList<Answer> getAllAnswers() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Answer.class);
		ArrayList<Answer> list = (ArrayList<Answer>) crit.list();
		tx.commit();
		session.close();
		return list;

	}

	@Override
	public void updateAnswer(Answer answer) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.update(answer); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteAnswer(Answer answer) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session session = sessionFact.openSession();

		session.beginTransaction();

		session.delete(answer); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addAnswer(Answer newAnswer) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(newAnswer);
		tx.commit();
		session.close();
		

	}
	
	@Override
	public void addAnswer(ArrayList<Answer> answerArr) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		for (int i=0; i<answerArr.size(); i++) {
			session.save(answerArr.get(i));
		}
		
		session.flush();
	    session.clear();
		tx.commit();
		session.close();
	}

}
