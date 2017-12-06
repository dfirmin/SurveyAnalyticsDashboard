package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Survey;
import com.sad.dto.Users;

public class UsersDaoImpl implements UsersDao {

	@Override
	public ArrayList<Users> getAllUsers() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Users.class);
		ArrayList<Users> list = (ArrayList<Users>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateUsers(Users user) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.update(user); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteUsers(Users user) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session session = sessionFact.openSession();

		session.beginTransaction();

		session.delete(user); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();
	}

	@Override
	public void addUsers(Users newUser) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newUser);
		tx.commit();
		session.close();
	}

}
