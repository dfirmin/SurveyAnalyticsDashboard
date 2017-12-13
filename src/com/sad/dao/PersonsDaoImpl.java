package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Offered_Answer;
import com.sad.dto.Persons;
import com.sad.util.HibernateUtil;

public class PersonsDaoImpl implements PersonsDao {
	
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public ArrayList<Persons> getAllPersons() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Persons.class);
		ArrayList<Persons> list = (ArrayList<Persons>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updatePersons(Persons person) {

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(person); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deletePersons(Persons person) {
		
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(person); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addPersons(Persons newPerson) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(newPerson);
		tx.commit();
		session.close();

	}


	

}
