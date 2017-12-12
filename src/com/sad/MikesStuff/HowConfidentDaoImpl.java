package com.sad.MikesStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HowConfidentDaoImpl implements HowConfidentDao {

	@Override
	public ArrayList<HowConfident> getAllConf(){
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "  select (@cnt \\:= @cnt + 1) as Pid, \n" + 
				"			t1.UserResponse as UserResponse,\n" + 
				"			t1.Week as Week,\n" + 
				"            t1.CohortID as CohortID FROM\n" + 
				"(select  avg(MikeDB.Answer.UserResponse) as UserResponse, \n" + 
				"            MikeDB.Answer.Week as Week, \n" + 
				"            MikeDB.Persons.CohortID as CohortID\n" + 
				"from MikeDB.Answer left join MikeDB.Persons\n" + 
				"on MikeDB.Answer.PersonID = MikeDB.Persons.PersonID\n" + 
				"where QuestionID =2 and MikeDB.Answer.Week is not null\n" + 
				"group by Week, CohortID) as t1\n" + 
				"CROSS JOIN (SELECT @cnt \\:= 0) AS dummy\n" + 
				"order by Week, CohortID";
		Query query = session.createSQLQuery(hql).addEntity(HowConfident.class);
		ArrayList<HowConfident> resultList = (ArrayList<HowConfident>) query.list();
		
		for (int i = 0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
		
		/*
		 * 	data.addColumn('number', 'Student ID');
        		data.addColumn('number', 'Hours Studied');
        		data.addColumn('number', 'Final');

        		data.addRows([
	          [0, 0, 67],  [1, 1, 88],   [2, 2, 77],
	          [3, 3, 93],  [4, 4, 85],   [5, 5, 91],
	          [6, 6, 71],  [7, 7, 78],   [8, 8, 93],
	          [9, 9, 80],  [10, 10, 82], [11, 0, 75],
	          [12, 5, 80], [13, 3, 90],  [14, 1, 72],
	          [15, 5, 75], [16, 6, 68],  [17, 7, 98],
	          [18, 3, 82], [19, 9, 94],  [20, 2, 79],
	          [21, 2, 95], [22, 2, 86],  [23, 3, 67],
	          [24, 4, 60], [25, 2, 80],  [26, 6, 92],
	          [27, 2, 81], [28, 8, 79],  [29, 9, 83]
        		]);
		 * 
		 */
		tx.commit();
		session.close();
		return resultList;
	}
}
