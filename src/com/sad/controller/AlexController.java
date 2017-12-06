package com.sad.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.Statement;
import com.sad.dto.SurveyQADto;

@Controller
public class AlexController {

	@RequestMapping("/getSurvey")
	public String getSurvey(Model model) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		int surveyID = 1;

		Query query = session.createSQLQuery(
				"SELECT survey_qaid,Question.QuestionID, QuestionText, QuestionType, Offered_Answer.OfferedAnswerID, AnswerText FROM Question\n"
						+ "inner JOIN Survey_QA " + "ON Question.QuestionID = Survey_QA.QuestionID "
						+ "inner JOIN Offered_Answer "
						+ "ON Offered_Answer.OfferedAnswerID = Survey_QA.OfferedAnswerID "
						+ "WHERE Survey_QA.SurveyID =" + surveyID + " Order by questionid;" + "")
				.addEntity(SurveyQADto.class);
		List<SurveyQADto> results = (List<SurveyQADto>) query.list();

		String message = ("<form action='submit' method='get'><input hidden value='" + surveyID + "'>");

		for (int i = 0; i < results.size(); i++) {
			/*
			 * message += (results.get(i).getQuestionID()+ results.get(i).getQuestionText()+
			 * results.get(i).getQuestionType()+ results.get(i).getOfferedAnswerID()+
			 * results.get(i).getAnswerText());
			 */
			System.out.println(i);
			int questionID = results.get(i).getQuestionID();
			String questionType = results.get(i).getQuestionType();

			switch (questionType) {
			case "radio":

				message += ("<fieldset name='" + questionID + "'>");
				message += ("<input hidden name='question" + questionID + "' value ='" + questionID + "'><br><label>"
						+ results.get(i).getQuestionText() + "</label><br>");
		

				boolean continueLoop = true;
					while (continueLoop) {
						message += ("<input type='radio' name ='" + questionID + "' value='"
								+ results.get(i).getAnswerText() + "'>" + results.get(i).getAnswerText() + "<br>");
						i++;
						if (results.size() == i || !(questionID == results.get(i).getQuestionID())) {
							continueLoop = false;
						}
						
					}
				
				i--;
				message += ("</fieldset>");
				break;
			case "slider":
				message += ("<input hidden name='question" + questionID + "' value ='" + questionID + "'><label>"
						+ results.get(i).getQuestionText() + "</label> <br>");

				String answer1 = results.get(i).getAnswerText();
				i++;
				String answer2 = results.get(i).getAnswerText();

				String[] arr1 = answer1.split(":");
				String[] arr2 = answer2.split(":");

				message += ("<input type='range' min='" + arr1[0] + "' max='" + arr2[0]
						+ "' value='5' list='tickmarks'>");
				message += ("<datalist id='tickmarks'><option value='0' label='" + arr1[1]
						+ "'><option value='1'><option value='2'><option value='3'><option value='4'><option value='5' ><option value='6'><option value='7'><option value='8'><option value='9'><option value='10' label='"
						+ arr2[1] + "'></datalist><br>");

				break;
			case "drop-down":
				break;
			case "short answer":
				message += ("<input hidden name='question" + questionID + "' value ='" + questionID + "'><label>"
						+ results.get(i).getQuestionText() + "</label> <br>"
						+ "<input type='text' value='' name='question" + questionID + "'> <br><br>");
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

}
