package com.sad.MikesStuff;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Jobs_AppliedDaoImpl implements Jobs_AppliedDao {

	@Override
	public ArrayList<Jobs_Applied> getJobsApplied(){
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select userresponse, count(userresponse) from Answer where questionid = 26 group by userresponse";
		Query query = session.createSQLQuery(hql).addEntity(Jobs_Applied.class);
		//query.setParameter("userresponse", 1);
		//query.setParameter("count(userresponse)", 1);
		ArrayList<Jobs_Applied> resultList = (ArrayList<Jobs_Applied>) query.list();
		
		for (int i = 0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
		
		tx.commit();
		session.close();
		return resultList;
	}
}
