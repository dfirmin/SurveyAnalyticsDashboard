package com.sad.controller;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sad.dao.AnswerDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.Jobs_Applied;
import com.sad.dto.SummaryResult;
import com.sad.dto.SurveyQADto;

@Controller
public class MikeHomeController {
	
	@RequestMapping("/v")
	public String visualizeFeeling(Model model) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		confidenceChart(model,session);
		jobs_applied(model,session);
		//OPTION 1
		
		session.close();
		return "visual";
	}
	
	public static void jobs_applied(Model model, Session session) {
		Transaction tx = session.beginTransaction();
		String hql = "select userresponse, count(userresponse) from Answer where questionid = 26 group by userresponse";
		Query query = session.createSQLQuery(hql).addEntity(Jobs_Applied.class);
		//query.setParameter("userresponse", 1);
		//query.setParameter("count(userresponse)", 1);
		List<Jobs_Applied> resultList = query.list();
		
		for (int i = 0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
		
		tx.commit();
		
		String js_statement = "[['Number of Jobs Applied', 'Count'],";
		
		for (int j=0; j<resultList.size(); j++) {
			js_statement += "['" + resultList.get(j).getJobs_applied_label() + "', " + resultList.get(j).getCount() + "]";
			if (j != resultList.size()-1) {
				js_statement += ",";
			}
		}
		
		js_statement += "]";
		
		System.out.println(js_statement);
		
		model.addAttribute("getJobsApp", js_statement);
		/*
		[
         ['Number of Jobs Applied', 'Count'],
         ['0-5',     11],
         ['5-10',      2],
         ['10-20',  2],
         ['Watch TV', 2],
         ['Sleep',    7]
       ]
       */
	}
	
	public static void confidenceChart(Model model, Session session) {
		Transaction tx = session.beginTransaction();
		String hql = "select (@cnt \\:= @cnt + 1) as Pid, table2.Cohortid as CohortID, table2.userResponse as userResponse, table2.counter as counter from\n" + 
				"(select @s \\:=@s+1 Pid, Persons.CohortID as Cohortid, table1.userresponse as userResponse, count(Userresponse) as counter from\n" + 
				"		(select PersonID, UserResponse from Answer where questionid =1) as table1\n" + 
				"	inner join Persons on Persons.PersonID = table1.PersonID\n" + 
				"    group by cohortid, Userresponse) as table2\n" + 
				"CROSS JOIN (SELECT @cnt \\:= 0) AS dummy;";
		Query query = session.createSQLQuery(hql).addEntity(SummaryResult.class);
		//query.setParameter("questionID", 1);
		//query.setParameter("cohortID", 1);
		List<SummaryResult> resultList = query.list();
		
		for (int i = 0; i <resultList.size(); i++) {
			System.out.println(resultList.get(i).toString());
		}
		
		System.out.println(resultList.get(0));
		
		tx.commit();

		String js_statement = "[['Confidence','Great! Excited for the rest of bootcamp.', 'A little confused, but confident I will get it soon!', 'Totally Confused', 'Other'],";
		
		//Loop through ones for Java
		int java_great = 0;
		int net_great = 0;
		int front_great = 0;
		
		int java_little = 0;
		int net_little = 0;
		int front_little = 0;
		
		int java_total = 0;
		int net_total = 0;
		int front_total = 0;
		
		int java_other = 0;
		int net_other = 0;
		int front_other = 0;
		
		for (int j=0; j<resultList.size(); j++) {
			if ((resultList.get(j).getUserResponse().contains("Great!")) && (resultList.get(j).getCohortID() == 1)) {
				java_great = resultList.get(j).getCounter();
				System.out.println(java_great);
			}
			else if ((resultList.get(j).getUserResponse().contains("little")) && (resultList.get(j).getCohortID() == 1)) {
				java_little = resultList.get(j).getCounter();
				System.out.println(java_little);
			}
			else if ((resultList.get(j).getUserResponse().contains("Totally")) && (resultList.get(j).getCohortID() == 1)) {
				java_total = resultList.get(j).getCounter();	
				System.out.println(java_total);
			}
			else if ((resultList.get(j).getUserResponse().contains("Other")) && (resultList.get(j).getCohortID() == 1)) {
				java_other = resultList.get(j).getCounter();
				System.out.println(java_other);
			}
			else if ((resultList.get(j).getUserResponse().contains("Great!")) && (resultList.get(j).getCohortID() == 2)) {
				net_great = resultList.get(j).getCounter();
				System.out.println(net_great);
			}
			else if ((resultList.get(j).getUserResponse().contains("little")) && (resultList.get(j).getCohortID() == 2)) {
				net_little = resultList.get(j).getCounter();
				System.out.println(net_little);
			}
			else if ((resultList.get(j).getUserResponse().contains("Totally")) && (resultList.get(j).getCohortID() == 2)) {
				net_total = resultList.get(j).getCounter();
				System.out.println(net_total);
			}
			else if ((resultList.get(j).getUserResponse().contains("Other")) && (resultList.get(j).getCohortID() == 2)) {
				net_other = resultList.get(j).getCounter();
				System.out.println(net_other);
			}
			else if ((resultList.get(j).getUserResponse().contains("Great!")) && (resultList.get(j).getCohortID() == 3)) {
				front_great = resultList.get(j).getCounter();
				System.out.println(front_great);
			}
			else if ((resultList.get(j).getUserResponse().contains("little")) && (resultList.get(j).getCohortID() == 3)) {
				front_little = resultList.get(j).getCounter();
				System.out.println(front_little);
			}
			else if ((resultList.get(j).getUserResponse().contains("Totally")) && (resultList.get(j).getCohortID() == 3)) {
				front_total = resultList.get(j).getCounter();
				System.out.println(front_total);
			}
			else if ((resultList.get(j).getUserResponse().contains("Other")) && (resultList.get(j).getCohortID() == 3)) {
				front_other = resultList.get(j).getCounter();
				System.out.println(front_other);
			}
		}
		
		js_statement += "[ 'Java'," + java_great + "," + java_little + ","+ java_total + "," + java_other + "],";
		js_statement += "[ '.NET'," + net_great + "," + net_little + ","+ net_total + "," + net_other +  "],";
		js_statement += "[ 'Front End'," + front_great + "," + front_little + ","+ front_total + "," + front_other +  "]]";
		
		System.out.println(js_statement);
		
		model.addAttribute("getConf", js_statement);
		/*
		String list = " [ ['Number of Jobs Applied', 'Count'], ['0-5', 11], ['5-10', 2], ['10-20', 2],['Watch TV', 2], ['Sleep', 7]] ";
		System.out.println(list);
		model.addAttribute("list",list);
		*/
		
	}
	
	
	
	
	
	//Loop through ones for .NET
	
			//Loop through ones for Front End
			/*
			 * 	[
			 *  ['Java', '.NET', 'Front End'],
	            [1000, 400, 200],				//Great Confidence
	            [1170, 460, 250],				// Somewhat Confident
	            [660, 1120, 300],				// Little Confident
	            [1030, 540, 350]					// Other
	        		]
	        	 *	
			 */
					
			//List results = query.list();
			
			//OPTION 2
			/*
			Query query = session.createSQLQuery(
					"SELECT survey_qaid,Question.QuestionID, QuestionText, QuestionType, Offered_Answer.OfferedAnswerID, AnswerText FROM Question\n"
							+ "inner JOIN Survey_QA " + "ON Question.QuestionID = Survey_QA.QuestionID "
							+ "inner JOIN Offered_Answer "
							+ "ON Offered_Answer.OfferedAnswerID = Survey_QA.OfferedAnswerID "
							+ "WHERE Survey_QA.SurveyID =" + 1 + " Order by questionid;" + "")
					.addEntity(SurveyQADto.class);
			
			List<SurveyQADto> results = (List<SurveyQADto>) query.list();
			
			List results = query.list();
			*/
			
			
			//System.out.println(results);
	
	
	/*
	AnswerDaoImpl answer = new AnswerDaoImpl();
	ArrayList<Answer> list = answer.getAllAnswers();
	
	
	
	question1(list, model);
	
	question2(list, model);
	question3(list, model);
	question4(list, model);
	question5(list, model);
	
	model.addAttribute("list",list);
	String list = " [ ['Number of Jobs Applied', 'Count'], ['0-5', 11], ['5-10', 2], ['10-20', 2],['Watch TV', 2], ['Sleep', 7]] ";
	model.addAttribute("list",list);
	*/
	
	public static void question1(ArrayList<Answer> list, Model model) {
		
		
		ArrayList<String> labels = new ArrayList<String>();
		
		for (int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getQuestionID() != 1) {
				list.remove(i);
			}
		}
		
		
		
		
	}
	
	/*
	@RequestMapping("/nl")
	public ModelAndView naturalLanguage(Model model) {
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
				  NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
				  "16e04451-f41c-4ff2-9d71-2b82a2885591",
				  "gE4g5KcU6B0h"
				);
		
		String text =
				"I know the times are difficult! Our sales have been "
					      + "disappointing for the past three quarters for our data analytics "
					      + "product suite. We have a competitive data analytics product "
					      + "suite in the industry. But we need to do our job selling it! "
					      + "We need to acknowledge and fix our sales challenges. "
					      + "We can’t blame the economy for our lack of execution! "
					      + "We are missing critical sales opportunities. "
					      + "Our product is in no way inferior to the competitor products. "
					      + "Our clients are hungry for analytical tools to improve their "
					      + "business outcomes. Economy has nothing to do with it.";

		// WORKING WITH KEYWORDS //
		KeywordsOptions keywords= new KeywordsOptions.Builder()
				  .build();
		Features features = new Features.Builder()
				  .keywords(keywords)
				  .build();
		AnalyzeOptions parameters = new AnalyzeOptions.Builder().html(text).features(features).build();
		AnalysisResults results = service.analyze(parameters).execute();
		System.out.println("KEYWORDS");
		System.out.println(results);
		
		
		
		// WORKING WITH EMOTIONS //
		
		EmotionOptions emotion= new EmotionOptions.Builder()
				  .build();
		Features features2 = new Features.Builder()
				  .emotion(emotion)
				  .build();
		AnalyzeOptions parameters2 = new AnalyzeOptions
				.Builder()
				.html(text)
				.features(features2)
				.build();
		AnalysisResults results2 = service.analyze(parameters2).execute();
		System.out.println("EMOTIONS");
		System.out.println(results2);
		
		String overall_results = results.toString() + results2.toString();
		return new ModelAndView("ToneAnalyzer", "ta_result", overall_results);
	}
	
	/*
	@RequestMapping("/ta")
	public ModelAndView toneanalyzer(Model model) {
		ToneAnalyzer service = new ToneAnalyzer("2016-05-19");
		service.setUsernameAndPassword("8106386a-69c1-44a7-96ae-41a111039f21", "kM0OpgpSsKME");
		String text =
				"I know the times are difficult! Our sales have been "
					      + "disappointing for the past three quarters for our data analytics "
					      + "product suite. We have a competitive data analytics product "
					      + "suite in the industry. But we need to do our job selling it! "
					      + "We need to acknowledge and fix our sales challenges. "
					      + "We can’t blame the economy for our lack of execution! "
					      + "We are missing critical sales opportunities. "
					      + "Our product is in no way inferior to the competitor products. "
					      + "Our clients are hungry for analytical tools to improve their "
					      + "business outcomes. Economy has nothing to do with it.";
		
		ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
		ToneAnalysis tone = service.tone(toneOptions).execute();
		System.out.println(tone);
		return new ModelAndView("ToneAnalyzer", "ta_result", tone.toString());
	}
	*/
}