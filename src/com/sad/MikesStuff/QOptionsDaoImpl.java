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
		
		/*
		 * private int answerid;
			private int personid;
			private String firstname;
			private String lastname;
			private String cohortname;
			private int questionid;
			private int surveyid;
			private String userresponse;
			private String watsonresponse;
		 */
		
		String hql = 
				"select 	MikeDB.Survey_QA.Survey_QAID as SurveyQAID,\n" + 
				"			MikeDB.Survey_QA.QuestionID as QuestionID,\n" + 
				"			MikeDB.Survey_QA.OfferedAnswerID as OfferedAnswerID,\n" + 
				"            MikeDB.Offered_Answer.AnswerText as AnswerText\n" + 
				"from MikeDB.Survey_QA left join MikeDB.Offered_Answer \n" + 
				"on MikeDB.Survey_QA.OfferedAnswerID = MikeDB.Offered_Answer.OfferedAnswerID\n" + 
				"where MikeDB.Offered_Answer.AnswerText is not null and  MikeDB.Offered_Answer.AnswerText <> ' ';";
		
		Query q = session.createSQLQuery(hql).addEntity(QOptions.class);
		ArrayList<QOptions> list = (ArrayList<QOptions>) q.list();
		tx.commit();
		session.close();
		return list;

	}

}
