package com.sad.MikesStuff;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WhatConfDaoImpl implements WhatConfDao{
	
	@Override
	public ArrayList<WhatConf> getHowConf() {
	Configuration config = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = config.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	String hql = "Select (@s \\:= @s + 1) as Pid, t1.CohortID as CohortID, t1.WatsonResponse as WatsonResponse, t1.count as count\n" + 
			"	from\n" + 
			"    (select Persons.CohortID as CohortID, WatsonResponse as WatsonResponse, count(WatsonResponse) as count\n" + 
			"	from Answer \n" + 
			"	left join Persons on Answer.PersonID = Persons.PersonID\n" + 
			"	where QuestionID =3 \n" + 
			"	group by Persons.CohortID, Answer.WatsonResponse) as t1\n" + 
			"CROSS JOIN (SELECT @s \\:= 0) AS cnt;";
	Query q = session.createSQLQuery(hql).addEntity(WhatConf.class);
	ArrayList<WhatConf> resultList = (ArrayList<WhatConf>) q.list();
	
	for (int i = 0; i <resultList.size(); i++) {
		System.out.println(resultList.get(i).toString());
	}
	
	System.out.println(resultList.get(0));
	
	tx.commit();
	
	return resultList;
}
}
