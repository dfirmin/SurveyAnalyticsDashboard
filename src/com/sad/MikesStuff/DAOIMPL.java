package com.sad.MikesStuff;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

public class DAOIMPL implements DAO {
	
	@Override
	public ArrayList<Effective> getEE() {
		Session session = HC.configureHib();
		String hql = "select AnswerID, Week, UserResponse\n" + 
				"		from Answer\n" + 
				"		where QuestionID = 5 or QuestionID = 6 or QuestionID = 9 or QuestionID = 10\n" + 
				"		order by AnswerID;";
		Query q = session.createSQLQuery(hql).addEntity(Effective.class);
		ArrayList<Effective> resultList = (ArrayList<Effective>) q.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<WhatConf> getTT() {
		Session session = HC.configureHib();
		String hql = "Select (@s \\:= @s + 1) as Pid,  t1.WatsonResponse as WatsonResponse, t1.count as count\n" + 
				"	from\n" + 
				"    (select WatsonResponse as WatsonResponse, count(WatsonResponse) as count\n" + 
				"	from Answer \n" + 
				"	where QuestionID = 7 \n" + 
				"	group by WatsonResponse) as t1\n" + 
				"CROSS JOIN (SELECT @s \\:= 0) AS cnt;";
		Query q = session.createSQLQuery(hql).addEntity(WhatConf.class);
		ArrayList<WhatConf> resultList = (ArrayList<WhatConf>) q.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<WhatConf> getHowConf() {
		Session session = HC.configureHib();
		String hql = "Select (@s \\:= @s + 1) as Pid,  t1.WatsonResponse as WatsonResponse, t1.count as count\n" + 
				"	from\n" + 
				"    (select WatsonResponse as WatsonResponse, count(WatsonResponse) as count\n" + 
				"	from Answer \n" + 
				"	where QuestionID =3 \n" + 
				"	group by WatsonResponse) as t1\n" + 
				"CROSS JOIN (SELECT @s \\:= 0) AS cnt;";
		Query q = session.createSQLQuery(hql).addEntity(WhatConf.class);
		ArrayList<WhatConf> resultList = (ArrayList<WhatConf>) q.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<SummaryResult> getSummaryResults() {
		Session session = HC.configureHib();
		String hql = "select (@cnt \\:= @cnt + 1) as Pid, t2.Week as Week, t2.userResponse as userResponse, t2.counter as counter from\n" + 
				"							(select t1.Week as Week, t1.userresponse as userResponse, count(Userresponse) as counter from\n" + 
				"									(select Answer.PersonID as PersonID, Answer.Week as Week, Answer.UserResponse as userResponse \n" + 
				"										from Answer where Answer.QuestionID =1) as t1\n" + 
				"								inner join Persons on Persons.PersonID = t1.PersonID\n" + 
				"							group by Week, userResponse) as t2 \n" + 
				"						CROSS JOIN (SELECT @cnt \\:= 0) AS dummy\n" + 
				"					order by Week, \n" + 
				"						case \n" + 
				"							when userResponse like '%Great%' then 0\n" + 
				"                            when userResponse like '%little%' then 1\n" + 
				"                            when userResponse like '%Totally%' then 2\n" + 
				"                            when userResponse like '%Other%' then 3\n" + 
				"						end;";
		Query q = session.createSQLQuery(hql).addEntity(SummaryResult.class);
		ArrayList<SummaryResult> resultList = (ArrayList<SummaryResult>) q.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<Results> getAllResults() {
		Session session = HC.configureHib();
		String hql = 
				"SELECT t1.AnswerID as AnswerID,  \n" + 
				"				t1.PersonID as PersonID,  \n" + 
				"				t1.QuestionID as QuestionID,  \n" + 
				"				t1.FirstName as FirstName,  \n" + 
				"				t1.LastName as LastName,   \n" + 
				"				t1.SurveyID as SurveyID,   \n" + 
				"				t1.UserResponse as UserResponse,  \n" + 
				"				t1.WatsonResponse as WatsonResponse, \n" + 
				"				t1.SubmitDate as SubmitDate,  \n" + 
				"				Cohort.CohortName as CohortName  \n" + 
				"				FROM  \n" + 
				"					(SELECT Answer.*, \n" + 
				"						Persons.FirstName as FirstName,  \n" + 
				"						Persons.LastName as LastName,  \n" + 
				"						Persons.CohortID as CohortID \n" + 
				"						FROM Answer LEFT JOIN Persons on\n" + 
				"						Answer.PersonID = Persons.PersonID  \n" + 
				"					 ) as t1 \n" + 
				"				LEFT JOIN Cohort on t1.CohortID = Cohort.CohortID;";
		
		Query q = session.createSQLQuery(hql).addEntity(Results.class);
		ArrayList<Results> list = (ArrayList<Results>) q.list();
		session.close();
		return list;
	}
	
	@Override
	public ArrayList<QOptions> getAllOptions() {
		Session session = HC.configureHib();
		
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
		session.close();
		return list;

	}
	
	@Override
	public ArrayList<ProgramManagement> getAllPM(){
		Session session = HC.configureHib();
		String hql = "Select Answer.AnswerID as AnswerID, \n" + 
				"			Answer.QuestionID as QuestionID, \n" + 
				"            Answer.UserResponse as UserResponse,\n" + 
				"            Answer.WatsonResponse as WatsonResponse\n" + 
				"from Answer\n" + 
				"where Answer.QuestionID between 5 and 12\n" + 
				"order by Answer.AnswerID;";
		Query query = session.createSQLQuery(hql).addEntity(ProgramManagement.class);
		ArrayList<ProgramManagement> resultList = (ArrayList<ProgramManagement>) query.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<Jobs_Applied> getJobsApplied(){
		Session session = HC.configureHib();
		String hql = "select UserResponse, count(UserResponse) from Answer where questionid = 26 group by userresponse";
		Query query = session.createSQLQuery(hql).addEntity(Jobs_Applied.class);
		//query.setParameter("userresponse", 1);
		//query.setParameter("count(userresponse)", 1);
		ArrayList<Jobs_Applied> resultList = (ArrayList<Jobs_Applied>) query.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<HowConfident> getAllConf(){
		Session session = HC.configureHib();
		String hql = "  select (@cnt \\:= @cnt + 1) as Pid, \n" + 
				"			t1.UserResponse as UserResponse,\n" + 
				"			t1.Week as Week,\n" + 
				"            t1.CohortID as CohortID FROM\n" + 
				"(select  avg(Answer.UserResponse) as UserResponse, \n" + 
				"            Answer.Week as Week, \n" + 
				"            Persons.CohortID as CohortID\n" + 
				"from Answer left join Persons\n" + 
				"on Answer.PersonID = Persons.PersonID\n" + 
				"where QuestionID =2 and Answer.Week is not null\n" + 
				"group by Week, CohortID) as t1\n" + 
				"CROSS JOIN (SELECT @cnt \\:= 0) AS dummy\n" + 
				"order by Week, CohortID";
		Query query = session.createSQLQuery(hql).addEntity(HowConfident.class);
		ArrayList<HowConfident> resultList = (ArrayList<HowConfident>) query.list();
		session.close();
		return resultList;
	}
	
	@Override
	public ArrayList<HowConfident> getAllMatPace(){
		Session session = HC.configureHib();
		String hql = "  select (@cnt \\:= @cnt + 1) as Pid, \n" + 
				"			t1.UserResponse as UserResponse,\n" + 
				"			t1.Week as Week,\n" + 
				"            t1.CohortID as CohortID FROM\n" + 
				"(select  avg(Answer.UserResponse) as UserResponse, \n" + 
				"            Answer.Week as Week, \n" + 
				"            Persons.CohortID as CohortID\n" + 
				"from Answer left join Persons\n" + 
				"on Answer.PersonID = Persons.PersonID\n" + 
				"where QuestionID =4 and Answer.Week is not null\n" + 
				"group by Week, CohortID) as t1\n" + 
				"CROSS JOIN (SELECT @cnt \\:= 0) AS dummy\n" + 
				"order by Week, CohortID";
		Query query = session.createSQLQuery(hql).addEntity(HowConfident.class);
		ArrayList<HowConfident> resultList = (ArrayList<HowConfident>) query.list();
		session.close();
		return resultList;
	}
}
