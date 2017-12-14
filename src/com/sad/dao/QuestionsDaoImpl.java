package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Persons;
import com.sad.dto.Question;
import com.sad.util.HibernateUtil;

public class QuestionsDaoImpl implements QuestionDao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public ArrayList<Question> getAllQuestion() {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Question.class);
		ArrayList<Question> list = (ArrayList<Question>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateQuestion(Question question) {
		

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(question); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteQuestion(Question question) {


		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(question); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addQuestion(Question newQuestion) {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newQuestion);
		tx.commit();
		session.close();

	}

}
