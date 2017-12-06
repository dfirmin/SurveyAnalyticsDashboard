package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Survey_QA;

public interface Survey_QADao {
	
ArrayList<Survey_QA> getAllSurvey_QA();
	

	void addSurvey_QA(Survey_QA newSurveyQA);

	void deleteSurvey_QA(Survey_QA surveyqa);

	void updateSurvey_QA(Survey_QA surveyqa);

}
