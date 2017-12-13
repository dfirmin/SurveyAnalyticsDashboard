package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


import com.sad.dto.Survey;
import com.sad.dto.Users;
import com.sad.util.HibernateUtil;

public class UsersDaoImpl implements UsersDao {
	
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public ArrayList<Users> getAllUsers() {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Users.class);
		ArrayList<Users> list = (ArrayList<Users>) crit.list();
		tx.commit();
		session.close();
		return list;
	}
	
	@Override
	public ArrayList<Users> getAllUsers(String column, String str) {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.like(column, str));
		ArrayList<Users> list = (ArrayList<Users>) crit.list();
		tx.commit();
		session.close();
		return list;
	}
	

	@Override
	public void updateUsers(Users user) {
		

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(user); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteUsers(Users user) {
		

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(user); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();
	}

	@Override
	public void addUsers(Users newUser) {
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newUser);
		tx.commit();
		session.close();
	}

}
