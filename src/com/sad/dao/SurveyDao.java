package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Survey;

public interface SurveyDao {
	
ArrayList<Survey> getAllSurveys();
	

	void addSurvey(Survey newSurvey);

	void deleteSurvey(Survey survey);

	void updateSurvey(Survey survey);

}
