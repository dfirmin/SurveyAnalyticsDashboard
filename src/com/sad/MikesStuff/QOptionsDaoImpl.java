package com.sad.MikesStuff;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QOptionsDaoImpl implements QOptionsDao{
	
	@Override
	public ArrayList<QOptions> getAllOptions() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = 
				"select 	Survey_QA.Survey_QAID as SurveyQAID,\n" + 
				"			Survey_QA.QuestionID as QuestionID,\n" + 
				"			Survey_QA.OfferedAnswerID as OfferedAnswerID,\n" + 
				"            Offered_Answer.AnswerText as AnswerText\n" + 
				"from Survey_QA left join Offered_Answer \n" + 
				"on Survey_QA.OfferedAnswerID = Offered_Answer.OfferedAnswerID\n" + 
				"where Offered_Answer.AnswerText is not null and  Offered_Answer.AnswerText <> ' ';";
		
		Query q = session.createSQLQuery(hql).addEntity(QOptions.class);
		ArrayList<QOptions> list = (ArrayList<QOptions>) q.list();
		tx.commit();
		session.close();
		return list;

	}

}
