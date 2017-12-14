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
		String hql = "Select Answer.AnswerID as AnswerID, \n" + 
				"			Answer.QuestionID as QuestionID, \n" + 
				"            Answer.UserResponse as UserResponse,\n" + 
				"            Answer.WatsonResponse as WatsonResponse\n" + 
				"from Answer\n" + 
				"where Answer.QuestionID between 5 and 12\n" + 
				"order by Answer.AnswerID;";
		Query query = session.createSQLQuery(hql).addEntity(ProgramManagement.class);
		ArrayList<ProgramManagement> resultList = (ArrayList<ProgramManagement>) query.list();
		
		tx.commit();
		session.close();
		return resultList;
	}
}