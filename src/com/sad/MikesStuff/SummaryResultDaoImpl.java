package com.sad.MikesStuff;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SummaryResultDaoImpl implements SummaryResultDao{
	
	@Override
	public ArrayList<SummaryResult> getSummaryResults() {
	Configuration config = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = config.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	String hql = "select (@cnt \\:= @cnt + 1) as Pid, t2.Cohortid as CohortID, t2.userResponse as userResponse, t2.counter as counter from\n" + 
			"			(select MikeDB.Persons.CohortID as Cohortid, t1.userresponse as userResponse, count(Userresponse) as counter from\n" + 
			"					(select MikeDB.Answer.PersonID as PersonID, MikeDB.Answer.UserResponse as userResponse \n" + 
			"						from MikeDB.Answer where MikeDB.Answer.QuestionID =1) as t1\n" + 
			"				inner join MikeDB.Persons on MikeDB.Persons.PersonID = t1.PersonID\n" + 
			"			group by MikeDB.Persons.cohortid, userResponse) as t2\n" + 
			"		CROSS JOIN (SELECT @cnt \\:= 0) AS dummy;";
	Query q = session.createSQLQuery(hql).addEntity(SummaryResult.class);
	ArrayList<SummaryResult> resultList = (ArrayList<SummaryResult>) q.list();
	
	for (int i = 0; i <resultList.size(); i++) {
		System.out.println(resultList.get(i).toString());
	}
	
	System.out.println(resultList.get(0));
	
	tx.commit();
	
	return resultList;
}
}
