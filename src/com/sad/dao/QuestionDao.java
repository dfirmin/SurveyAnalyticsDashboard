package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Question;

public interface QuestionDao {
	
ArrayList<Question> getAllQuestion();
	

	void addQuestion(Question newQuestion);

	void deleteQuestion(Question question);

	void updateQuestion(Question question);

}
