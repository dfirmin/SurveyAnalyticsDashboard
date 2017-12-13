package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.sad.dto.Answer;
import com.sad.util.HibernateUtil;

public class AnswerDaoImpl implements AnswerDao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public ArrayList<Answer> getAllAnswers() {
	

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
		

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(answer); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteAnswer(Answer answer) {
		
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(answer); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addAnswer(Answer newAnswer) {
	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(newAnswer);
		tx.commit();
		session.close();
		

	}
	
	@Override
	public void addAnswer(ArrayList<Answer> answerArr) {
		
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
