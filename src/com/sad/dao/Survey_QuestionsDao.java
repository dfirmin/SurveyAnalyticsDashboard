package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Survey_Question;

public interface Survey_QuestionsDao {
	
ArrayList<Survey_Question> getAllSurvey_QuestionsDaos();
	
	
	void addSurvey_QuestionsDao(Survey_Question newSurveyQuestion);

	void deleteSurvey_QuestionsDao(Survey_Question surveyquestion);

	void updateSurvey_QuestionsDao(Survey_Question surveyquestion);

}
