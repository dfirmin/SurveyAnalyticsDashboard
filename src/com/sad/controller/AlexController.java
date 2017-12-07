package com.sad.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
import com.sad.dao.UsersDaoImpl;
import com.sad.dto.Answer;
import com.sad.dto.SurveyQADto;
import com.sad.dto.Users;

@Controller
public class AlexController {

	ArrayList<String> questionIDs = new ArrayList<String>();

	@RequestMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
	
	@RequestMapping("/loginPage")
	public String showLogin() {
		return "loginPage";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		UsersDaoImpl users = new UsersDaoImpl();
		
		ArrayList<Users> list = users.getAllUsers("email", email);
		
		String webPage = "loginPage";
		
		if(!list.isEmpty()) {
			
			String dbPassword = list.get(0).getPassword();
			
			
			if(password.equals(dbPassword)) {
				model.addAttribute("firstName", list.get(0).getFirstName() );
				webPage = "dashboard";
			}
			else {
				String alert = "<script>alert('Password is incorrect. Try again.')</script>";
				model.addAttribute("alert", alert );
			}
		}
		else {
			String alert = "<script>alert('Username does not exist. Try again.')</script>";
			model.addAttribute("alert", alert );	
		}
		
		
		return webPage;
	}
	
	@RequestMapping("/getSurvey")
	public String getSurvey(Model model) {

		// initialize database connection
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		int surveyID = 1;

		// sql query to pull survey questions and answers
		Query query = session.createSQLQuery(
				"SELECT survey_qaid,Question.QuestionID, QuestionText, QuestionType, Offered_Answer.OfferedAnswerID, AnswerText FROM Question\n"
						+ "inner JOIN Survey_QA " + "ON Question.QuestionID = Survey_QA.QuestionID "
						+ "inner JOIN Offered_Answer "
						+ "ON Offered_Answer.OfferedAnswerID = Survey_QA.OfferedAnswerID "
						+ "WHERE Survey_QA.SurveyID =" + surveyID + " Order by questionid;" + "")
				.addEntity(SurveyQADto.class);
		List<SurveyQADto> results = (List<SurveyQADto>) query.list();

		String message = ("<form action='submit' method='get'><input hidden name = 'surveyID' value='" + surveyID
				+ "'>");

		// select bootcamp dropdown
		message += ("<label>Select Your Bootcamp</label>");
		message += ("<select name = 'cohorts' required>");
		message += ("<option value='Java'>Java</option>");
		message += ("<option value='.Net'>.Net</option>");
		message += ("<option value='Front-End'>Front-End</option>");
		message += ("</select ><br>");

		// select person name dropdown
		message += ("<label>Select Your Name</label>");
		message += ("<select name = 'userId' required>");
		message += ("<option value='1'>Player1</option>");
		message += ("<option value='1'>Taco</option>");
		message += ("<option value='1'>Jake the Dog</option>");
		message += ("</select ><br>");

		// loop through each row in query table
		for (int i = 0; i < results.size(); i++) {
			/*
			 * message += (results.get(i).getQuestionID()+ results.get(i).getQuestionText()+
			 * results.get(i).getQuestionType()+ results.get(i).getOfferedAnswerID()+
			 * results.get(i).getAnswerText());
			 */

			// initial values
			int questionID = results.get(i).getQuestionID();
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
					message += ("<input type='radio' name ='" + questionID + "' value='"
							+ results.get(i).getAnswerText() + "' required>" + results.get(i).getAnswerText() + "<br>");
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

				// split answer string to seperate values, string is formatted as "1:Minimum
				// value"
				String[] arr1 = answer1.split(":");
				String[] arr2 = answer2.split(":");

				// add slider input to html form
				message += ("<input name ='" + questionID + "' type='range' min='" + arr1[0] + "' max='" + arr2[0]
						+ "' value='5' list='tickmarks'>");
				message += ("<datalist id='tickmarks'><option value='0' label='" + arr1[1]
						+ "'><option value='1'><option value='2'><option value='3'><option value='4'><option value='5' ><option value='6'><option value='7'><option value='8'><option value='9'><option value='10' label='"
						+ arr2[1] + "'></datalist><br>");
				break;

			case "drop-down":
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
		}
		message += ("<input type='submit' value='SUBMIT'></form>");
		tx.commit();

		model.addAttribute("results", message);
		session.close();

		return "testSurvey";
	}

	@RequestMapping("/submit")
	public String submitToDB(HttpServletRequest request, Model model) {
		System.out.println(request.getParameter("cohort"));
		int personID = Integer.valueOf(request.getParameter("userId"));
		int surveyID = Integer.valueOf(request.getParameter("surveyID"));

		int[] watsonTopic = { 3, 7, 11, 15, 16, 19, 20, 22, 23 };
		int[] watsonEmotion = { 1, 8, 12, 25 };

		AnswerDaoImpl transfer = new AnswerDaoImpl();

		NaturalLanguageUnderstanding service = getNLUService();

		for (int i = 0; i < questionIDs.size(); i++) {

			int questionID = Integer.valueOf(questionIDs.get(i));

			String watsonString = "";
			System.out.println(questionIDs.get(i));
			String answer = request.getParameter(questionIDs.get(i)).toString();

			

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
			
			Answer answerDto = new Answer(0, personID, questionID, surveyID, answer, watsonString, null);
			transfer.addAnswer(answerDto);

		}

		return "success";
	}

	public NaturalLanguageUnderstanding getNLUService() {
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
				NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27, "16e04451-f41c-4ff2-9d71-2b82a2885591",
				"gE4g5KcU6B0h");
		return service;
	}

	public String WatsonTopic(String text, NaturalLanguageUnderstanding service) {

		KeywordsOptions keywords = new KeywordsOptions.Builder().build();
		Features features = new Features.Builder().keywords(keywords).build();
		AnalyzeOptions parameters = new AnalyzeOptions.Builder().html(text).features(features).build();
		AnalysisResults results = service.analyze(parameters).execute();
		System.out.println("KEYWORDS");
		System.out.println(results);
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
		

		return emotion + ":" + maxVal;
	}
	
	
	/*
	 * Function returns lower limit week-of-date in relation to start date
	 */
	public LocalDate setDate() {
		
		/* 	LocalDate => SQL Date

			LocalDate locald = LocalDate.of(1967, 06, 22);
			Date date = Date.valueOf(locald); // Magic happens here!
			r.setDateOfBirth(date);
			
		
			SQL Date => LocalDate
			
			Date date = r.getDate();
			LocalDate localD = date.toLocalDate();
			
		 */
		
		LocalDate startDate = LocalDate.of(2017, 12, 04);
		LocalDate resultDate = startDate;
		Long weeks = 1L;
		boolean searching = true;
		
		while(searching) {
			
			if(LocalDate.now().isBefore(resultDate.plusWeeks(weeks))) {
				searching = false;
			}
			else {
				resultDate = resultDate.plusWeeks(weeks);
			}
		}

		return resultDate;
	}

}
