package com.sad.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.sad.dao.AnswerDaoImpl;
import com.sad.dao.CohortDaoImpl;
import com.sad.dao.UsersDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.Cohort;
import com.sad.dto.Persons;
import com.sad.dto.Survey;
import com.sad.dto.SurveyQADto;
import com.sad.dto.Users;
import com.sad.info.Credentials;
import com.sad.util.HibernateUtil;

@Controller
public class AlexController {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	ArrayList<String> questionIDs = new ArrayList<String>();
	ArrayList<Answer> answers = new ArrayList<Answer>();
	int surveyID = 1;
	int cohortId = 0;
	int userId = 0;
	Model model1;
	java.sql.Date weekOfDate;
	int week = 0;

	@RequestMapping("/getSurvey")
	public String getSurvey(Model model) {
		int questionNum = 0;
		int pageNum = 1;
		String message = "";
		answers.clear();

		// initialize database connection
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		surveyID = 1;
     
		// sql query to pull survey questions and answers
		Query query = session.createSQLQuery(
				"SELECT survey_qaid,Question.QuestionID, QuestionText, QuestionType, Offered_Answer.OfferedAnswerID, AnswerText, IsCustom FROM Question "
						+ "inner JOIN Survey_QA " + "ON Question.QuestionID = Survey_QA.QuestionID "
						+ "inner JOIN Offered_Answer "
						+ "ON Offered_Answer.OfferedAnswerID = Survey_QA.OfferedAnswerID "
						+ "WHERE Survey_QA.SurveyID =" + surveyID
						+ " Order by questionid,  survey_qaid, OfferedAnswerID ;" + "")
				.addEntity(SurveyQADto.class);
		List<SurveyQADto> results = (List<SurveyQADto>) query.list();

		query = session.createSQLQuery(
				"select cohortID, cohortname, Max(cohortSemester) as cohortSemester, Max(startdate) as startDate from Cohort group by cohortname order by cohortid")
				.addEntity(Cohort.class);
		List<Cohort> cohorts = (List<Cohort>) query.list();
		System.out.println(cohorts.toString());

		query = session.createSQLQuery("select * from Survey where surveyId =" + surveyID + ";")
				.addEntity(Survey.class);
		List<Survey> surveyDto = (List<Survey>) query.list();

		message = ("<form action='next' method='get'>");

		ArrayList<ArrayList<String>> persons = new ArrayList<ArrayList<String>>();
		// List<List<Persons>> personList = new ArrayList< List<Persons>>();

		// select bootcamp dropdown
		message += ("<img class='center-block imgSize center' src='resources/grandcircuslogo.png'>");
		message += ("<h1 class='surveyHeader'>" + surveyDto.get(0).getDescription() + "</h1>");
		message += ("<p class='center'>Feedback is a gift!</p>");

		message += ("<label>Select Your Bootcamp</label>");
		message += ("<select id='cohorts' onChange='selectedDrop(this);' name = 'cohorts' required><option selected='0'>Select a language</option>");

		for (int i = 0; i < cohorts.size(); i++) {
			message += ("<option value='" + cohorts.get(i).getCohortID() + "'>" + cohorts.get(i).getCohortName()
					+ "</option>");

			query = session.createSQLQuery("select * from Persons where cohortId =" + cohorts.get(i).getCohortID() + "")
					.addEntity(Persons.class);
			List<Persons> personsInCohort = (List<Persons>) query.list();

			ArrayList<String> personStrings = new ArrayList<String>();
			for (int j = 0; j < personsInCohort.size(); j++) {
				Persons person = new Persons();
				person = personsInCohort.get(j);
				personStrings.add("'" + String.valueOf(person.getPersonID()) + ":" + person.getFirstName() + ""
						+ person.getLastName() + "'");
			}
			persons.add(personStrings);
		}

		System.out.println(persons.toString());
		model.addAttribute("persons", persons);

		message += ("</select ><br>");

		questionNum++;
		questionNum++;
		// select person name dropdown
		message += ("<label>Select Your Name</label>");
		message += ("<select id='students' name = 'students' required >");
		message += ("<option selected='0' >Select an option from above</option>");
		message += ("</select ><br>");

		int questionID  = 0;
		int qIndex = 0;
		// loop through each row in query table
		for (int i = 0; i < results.size(); i++) {
			/*
			 * message += (results.get(i).getQuestionID()+ results.get(i).getQuestionText()+
			 * results.get(i).getQuestionType()+ results.get(i).getOfferedAnswerID()+
			 * results.get(i).getAnswerText());
			 */
			questionID = results.get(i).getQuestionID();

			if (questionNum >= 8) {
				String next = pageNum + 1 + ":" + questionNum + ":" + (qIndex);
				message += ("<input hidden name = 'end' value='0'>");

				message += ("<input hidden name = 'num' value='" + next + "'>");
				message += ("<input type='submit' value='NEXT'></form>");
				model.addAttribute("page" + pageNum, message);
				pageNum++;
				message = "";
				questionNum = 0;
				message = ("<form action='next' method='post'>");
			}  
			// initial values
			String questionType = results.get(i).getQuestionType();
			boolean continueLoop = true;

			// for each questionType in row, perform different functionality
			switch (questionType) {

			case "radio":
				questionIDs.add(String.valueOf(questionID));
				message += ("<fieldset name='" + questionID + "'>");
				message += ("<br><label>" + results.get(i).getQuestionText() + "</label><br>");
				continueLoop = true;

				// loop through rows to catch each answer for radio button, advancing row index
				// as long as questionIDs match
				while (continueLoop) {
					if (results.get(i).getIsCustom() == true) {

						message += ("<input id='rb" + questionID
								+ "' type='radio' onChange='customRadio(this);' name ='" + questionID + "' value='"
								+ results.get(i).getAnswerText() + "' required>" + results.get(i).getAnswerText());
						message += ("<input id='" + questionID + "'type='text' value='' disabled>");
					} else {
						message += ("<input type='radio' name ='" + questionID + "' value='"
								+ results.get(i).getAnswerText() + "' required>" + results.get(i).getAnswerText());
					}
					message += ("<br>");

					i++;
					if (results.size() == i || !(questionID == results.get(i).getQuestionID())) {
						continueLoop = false;
					}
				}

				i--;
				message += ("</fieldset>");
				break;

			case "slider":
				questionIDs.add(String.valueOf(questionID));
				message += ("<label>" + results.get(i).getQuestionText() + "</label> <br>");

				// get lower and upper bounds for slider
				String answer1 = results.get(i).getAnswerText();
				i++;
				String answer2 = results.get(i).getAnswerText();

				// split answer string to separate values, string is formatted as "1:Minimum
				// value"
				String[] arr1 = answer1.split(":");
				String[] arr2 = answer2.split(":");

				// add slider input to html form
				message += ("<input name ='" + questionID + "' type='range' min='" + arr1[0] + "' max='" + arr2[0]
						+ "' value='5' list='tickmarks'>");
				message += ("<datalist id='tickmarks'><option value='1' label='" + arr1[1]
						+ "'><option value='2'><option value='3'><option value='4'><option value='5' ><option value='6'><option value='7'><option value='8'><option value='9'><option value='10' label='"
						+ arr2[1] + "'></datalist><br>");
				break;

			case "drop-down":

				if (questionNum > 5) {
					String next = pageNum + 1 + ":" + questionNum + ":" + (qIndex);
					message += ("<input hidden name = 'end' value='0'>");

					message += ("<input hidden name = 'num' value='" + next + "'>");
					message += ("<input type='submit' value='NEXT'></form>");
					model.addAttribute("page" + pageNum, message);
					pageNum++;
					message = "";
					questionNum = 0;
					message = ("<form action='next' method='post'>");
				}

				questionIDs.add(String.valueOf(questionID));
				message += ("<label>" + results.get(i).getQuestionText() + "</label><br>");
				message += ("<select name ='" + questionID + "''>");
				continueLoop = true;

				// loop while questionIDs match, get next dropdown value, advance row index
				while (continueLoop) {
					message += ("<option value='" + results.get(i).getAnswerText() + "'>"
							+ results.get(i).getAnswerText() + "</option>");
					i++;
					if (results.size() == i || !(questionID == results.get(i).getQuestionID())) {
						continueLoop = false;
					}
				}
				message += ("</select ><br><br>");
				i--;
				break;

			case "short answer":
				questionIDs.add(String.valueOf(questionID));
				message += ("<label>" + results.get(i).getQuestionText() + "</label> <br>"
						+ "<input type='text' value='' name='" + questionID + "'> <br><br>");
				break;

			default:
				break;

			}
			qIndex++;
			questionNum++;
		}
		String next = pageNum + 1 + ":" + questionNum + ":" + (qIndex);

		message += ("<input hidden name = 'end' value='1'>");
		message += ("<input hidden name = 'num' value='" + next + "'>");
		message += ("<input type='submit' value='SUBMIT'></form>");
		tx.commit();

		model.addAttribute("page" + pageNum, message);
		model1 = model;
		model.addAttribute("survey", model.asMap().get("page1"));
		session.close();

		return "testSurvey";
	}

	@RequestMapping("/next")
	public String nextPage(@RequestParam("num") String n, Model model, HttpServletRequest request) {
		int pageNum = Integer.valueOf(n.split(":")[0]);
		int qCount = Integer.valueOf(n.split(":")[1]);
		System.out.println(n);

		System.out.println("Array:" + answers.toString());

		if ((pageNum - 1) == 1) {
			qCount -= 2;
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			int cohortID = Integer.valueOf(request.getParameter("cohorts"));
			Query query = session.createSQLQuery(
					"select cohortID , cohortname, cohortSemester, startdate  from Cohort where cohortID =" + cohortID)
					.addEntity(Cohort.class);
			List<Cohort> cohort = (List<Cohort>) query.list();

			String startDate = cohort.get(0).getStartDate();
			String dateStr = setDate(startDate);
			weekOfDate = java.sql.Date.valueOf(dateStr.split(":")[1]);
			week = Integer.valueOf(dateStr.split(":")[0]);
			userId = Integer.valueOf(request.getParameter("students"));
		}
		
		int qID = Integer.valueOf(n.split(":")[2]);
		int[] watsonTopic = { 3, 7, 11, 15, 22, 23 };
		int[] watsonEmotion = { 8, 12, 25 };

		NaturalLanguageUnderstanding service = getNLUService();
		int arrLength = answers.size();
		for (int i = (qID-qCount); i < (qID); i++) {
			System.out.println(i);
			System.out.println("q:" + qCount);
			int questionID = Integer.valueOf(questionIDs.get(i));

			String watsonString = "";
			System.out.println(questionIDs.get(i));
			String answer = request.getParameter(questionIDs.get(i)).toString();
			if (answer != null) {
				System.out.println(answer);

				if (!answer.equals("")) {
					for (int j = 0; j < watsonTopic.length; j++) {
						if (watsonTopic[j] == questionID) {
							watsonString = WatsonTopic(answer, service);
						}
					}

					for (int k = 0; k < watsonEmotion.length; k++) {
						if (watsonEmotion[k] == Integer.valueOf(questionIDs.get(i))) {
							watsonString = WatsonEmotion(answer, service);
						}
					}
				}

				Answer answerDto = new Answer(0, userId, questionID, surveyID, answer, watsonString, weekOfDate, week);
				System.out.println(answerDto.toString());
				answers.add(i, answerDto);
			}/* else {
				for (i = (arrLength - 1); i > (arrLength - 8); i--) {
					System.out.println(i);
					answers.remove(i);
				}
			}*/
		}

		int ended = Integer.valueOf(request.getParameter("end"));

		if (ended == 1) {
			AnswerDaoImpl transfer = new AnswerDaoImpl();
			for(int i=0; i < answers.size(); i++) {
			transfer.addAnswer(answers.get(i));
			}
			return "success";
		}

		String page = "page" + pageNum;
		model.addAttribute("survey", model1.asMap().get(page));

		return "testSurvey";
	}

	@RequestMapping("/back")
	public String lastPage(@RequestParam("num") int n, Model model) {
		String pageNum = "page" + n;
		model.addAttribute("survey", model1.asMap().get(pageNum));
		return "testSurvey";
	}

	@RequestMapping("/submit")
	public String submitToDB(@RequestParam("num") String n, Model model, HttpServletRequest request) {
		/*
		 * Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 * SessionFactory sessionFactory = config.buildSessionFactory(); Session session
		 * = sessionFactory.openSession(); Transaction tx = session.beginTransaction();
		 * System.out.println(request.getParameter("cohorts")); int cohortID =
		 * Integer.valueOf(request.getParameter("cohorts"));
		 * System.out.println(cohortID); Query query = session.createSQLQuery(
		 * "select cohortID , cohortname, cohortSemester, startdate  from cohort where cohortID ="
		 * + cohortID) .addEntity(Cohort.class); List<Cohort> cohort = (List<Cohort>)
		 * query.list();
		 * 
		 * String startDate = cohort.get(0).getStartDate(); String dateStr =
		 * setDate(startDate); java.sql.Date weekOfDate =
		 * java.sql.Date.valueOf(dateStr.split(":")[1]); int week =
		 * Integer.valueOf(dateStr.split(":")[0]);
		 */

		AnswerDaoImpl transfer = new AnswerDaoImpl();

		int pageNum = Integer.valueOf(n.split(":")[0]);
		int qCount = Integer.valueOf(n.split(":")[1]);
		System.out.println(n);

		System.out.println("Array:" + answers.toString());

		if ((pageNum - 1) == 1) {
			qCount -= 2;
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			int cohortID = Integer.valueOf(request.getParameter("cohorts"));
			Query query = session.createSQLQuery(
					"select cohortID , cohortname, cohortSemester, startdate  from Cohort where cohortID =" + cohortID)
					.addEntity(Cohort.class);
			List<Cohort> cohort = (List<Cohort>) query.list();

			String startDate = cohort.get(0).getStartDate();
			String dateStr = setDate(startDate);
			weekOfDate = java.sql.Date.valueOf(dateStr.split(":")[1]);
			week = Integer.valueOf(dateStr.split(":")[0]);
			userId = Integer.valueOf(request.getParameter("students"));
		}

		int qID = Integer.valueOf(n.split(":")[2]) - qCount;
		int[] watsonTopic = { 3, 7, 11, 15, 16, 19, 20, 22, 23 };
		int[] watsonEmotion = { 1, 8, 12, 25 };

		NaturalLanguageUnderstanding service = getNLUService();
		int arrLength = answers.size();
		for (int i = qID; i < (qCount); i++) {
			System.out.println(i);
			System.out.println("q:" + qCount);
			int questionID = Integer.valueOf(questionIDs.get(i));

			String watsonString = "";
			System.out.println(questionIDs.get(i));
			String answer = request.getParameter(questionIDs.get(i)).toString();
			if (answer != null) {
				System.out.println(answer);

				if (!answer.equals("")) {
					for (int j = 0; j < watsonTopic.length; j++) {
						if (watsonTopic[j] == questionID) {
							watsonString = WatsonTopic(answer, service);
						}
					}

					for (int k = 0; k < watsonEmotion.length; k++) {
						if (watsonEmotion[k] == Integer.valueOf(questionIDs.get(i))) {
							watsonString = WatsonEmotion(answer, service);
						}
					}
				}

				Answer answerDto = new Answer(0, userId, questionID, surveyID, answer, watsonString, weekOfDate, week);
				System.out.println(answerDto.toString());
				answers.add(i, answerDto);
			}
		}

		String page = "page" + pageNum;
		for (int i = 0; i < answers.size(); i++) {
			transfer.addAnswer(answers.get(i));
		}
		return "success";
	}
	

	public NaturalLanguageUnderstanding getNLUService() {
		Credentials watson = new Credentials();
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
				NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27, watson.getWatsonUsername(),
				watson.getWatsonPassword());
		return service;
	}

	public String WatsonTopic(String text, NaturalLanguageUnderstanding service) {

		KeywordsOptions keywords = new KeywordsOptions.Builder().build();
		Features features = new Features.Builder().keywords(keywords).build();
		AnalyzeOptions parameters = new AnalyzeOptions.Builder().html(text).features(features).build();
		AnalysisResults results = service.analyze(parameters).execute();
		System.out.println("KEYWORDS");
		System.out.println(results);
		String watsonStr = jsonKeywordString(results.toString());
		if (watsonStr.equalsIgnoreCase("")) {
			return text;
		}
		return jsonKeywordString(results.toString());
	}

	public String WatsonEmotion(String text, NaturalLanguageUnderstanding service) {

		EmotionOptions emotion = new EmotionOptions.Builder().build();
		Features features2 = new Features.Builder().emotion(emotion).build();
		AnalyzeOptions parameters2 = new AnalyzeOptions.Builder().html(text).features(features2).build();
		AnalysisResults results2 = service.analyze(parameters2).execute();
		System.out.println("EMOTIONS");
		System.out.println(results2);
		return jsonEmotionString(results2.toString());
	}

	public String jsonKeywordString(String jsonStr) {
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONArray arr = jsonObj.getJSONArray("keywords");
		String result = "";
		for (int i = 0; i < arr.length(); i++) {
			JSONObject wordObj = (JSONObject) arr.get(i);
			result += wordObj.getString("text");
			if (i < (arr.length() - 1)) {
				result += ",";
			}
		}
		result = result.toUpperCase();
		return result;
	}
  
	public String jsonEmotionString(String jsonStr) {

		JSONObject jsonObj = new JSONObject(jsonStr);

		JSONObject emoObj = jsonObj.getJSONObject("emotion").getJSONObject("document").getJSONObject("emotion");

		Iterator<String> keys = emoObj.keys();

		Double maxVal = 0.0;
		String emotion = "";
		while (keys.hasNext()) {
			String key = keys.next();
			Double val = emoObj.getDouble(key);

			if (maxVal < val) {
				maxVal = val;
				emotion = key;
			}

		}
		
		emotion = emotion.toUpperCase();
 
		return emotion;
	}   
 
	/*
	 * Function returns lower limit week-of-date in relation to start date
	 */
	public String setDate(String str) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(str, formatter);

		LocalDate resultDate = startDate;
		Long weeks = 1L;
		boolean searching = true;
		int count = 1;
		while (searching) {

			if (LocalDate.now().isBefore(resultDate.plusWeeks(weeks))) {
				searching = false;
			} else {
				resultDate = resultDate.plusWeeks(weeks);
				count++;
	   		}
		}
		return count + ":" + String.valueOf(resultDate);
	}
	
	@RequestMapping("/surveyprefs")
	public String surveyPrefs(@RequestParam("id") String id, Model model) {
		
		model.addAttribute("surveyId", id);
		
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria crit = session.createCriteria(Survey.class);
    
        crit.add(Restrictions.eq("SurveyID", id));
		ArrayList<Survey> list = (ArrayList<Survey>) crit.list();
		Survey survey = (Survey) list.get(0);
				
		crit = session.createCriteria(Cohort.class);
		crit.addOrder(Order.desc("StartDate"));
		ArrayList<Cohort> cohortList = (ArrayList<Cohort>) crit.list();
		
		
		String[] surveyCohortIds = survey.getCohorts().split(",");
		ArrayList<Cohort> surveyCohorts = new ArrayList<Cohort>();
		
		
		String message = ("<form action='updateSurvey' method='post'>");
		message += ("<input type='text' placeholder='"+survey.getDescription()+"'><br>");
		
		message += ("<select id='cohorts' name = 'cohorts'><option value='' disabled selected>Select Section to Add</option>");
		
		for (int i=0; i< cohortList.size(); i++) {
			message += ("<option value='"+cohortList.get(i).getCohortID()+"' disabled selected>'"+cohortList.get(i).getCohortName()+"'</option>");
			for(int j=0; i < surveyCohortIds.length; i++) {
				int cohortId = Integer.valueOf(surveyCohortIds[i]);
				if (cohortList.get(i).getCohortID() == cohortId) {
					surveyCohorts.add(cohortList.get(i));
				}	
			}	
		}
		message += ("</select><br>");
		
		
		

		
		
		
        model.addAttribute("cohortList", list);
		
		return "survey";
	}

}
