package com.sad.MikesStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProgramManagementDaoImpl implements ProgramManagementDao {

	@Override
	public ArrayList<ProgramManagement> getAllPM(){
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "Select MikeDB.Answer.AnswerID as AnswerID, \n" + 
				"			MikeDB.Answer.QuestionID as QuestionID, \n" + 
				"            MikeDB.Answer.UserResponse as UserResponse,\n" + 
				"            MikeDB.Answer.WatsonResponse as WatsonResponse\n" + 
				"from MikeDB.Answer\n" + 
				"where MikeDB.Answer.QuestionID between 5 and 8\n" + 
				"order by MikeDB.Answer.AnswerID;";
		Query query = session.createSQLQuery(hql).addEntity(ProgramManagement.class);
		ArrayList<ProgramManagement> resultList = (ArrayList<ProgramManagement>) query.list();
		
		for (int i = 0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
		
		tx.commit();
		session.close();
		return resultList;
	}
}