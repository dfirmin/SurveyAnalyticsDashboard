package com.sad.daofactory;

import com.sad.dao.AnswerDaoImpl;

public class DaoFactory {

	public static final String ANSWERDAO = "answer";
	public static final String COHORTDAO = "cohort";
	public static final String OFFERED_ANSWERDAO = "offeredanswer";
	public static final String PERSONSDAO = "person";
	public static final String QUESTIONDAO = "question";
	public static final String SURVEYQADAO = "surveyd";
	public static final String SURVEYQUESTIONSDAO = "surveyquestions";
	public static final String SURVEYDAO = "survey";
	
	

	public static  AnswerDaoImpl getInstance(String type) {
		AnswerDaoImpl daoimpl = null;
		switch (type) {
		case ANSWERDAO: 
			daoimpl = new AnswerDaoImpl();
			break;
		default:
			break;
		}
		return daoimpl;
	}

}