package com.sad.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sad.dto.Answer;
import com.sad.dto.Cohort;
import com.sad.util.HibernateUtil;

public class CohortDaoImpl implements CohortDao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public ArrayList<Cohort> getAllCohorts() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Cohort.class);
		ArrayList<Cohort> list = (ArrayList<Cohort>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void updateCohort(Cohort cohort) {

		Session codes = sessionFactory.openSession();

		codes.beginTransaction();

		codes.update(cohort); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

	}

	@Override
	public void deleteCohort(Cohort cohort) {
	
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(cohort); // delete the object from the list

		session.getTransaction().commit(); // delete the row from the database table
		session.close();

	}

	@Override
	public void addCohort(Cohort cohort) {
	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(cohort);
		tx.commit();
		session.close();

	}

}
