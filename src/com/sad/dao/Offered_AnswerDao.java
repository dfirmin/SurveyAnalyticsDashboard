package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Offered_Answer;



public interface Offered_AnswerDao {
	
ArrayList<Offered_Answer> getAllOffered_Answer();
	
	
	void addOffered_Answer(Offered_Answer newOfferedAnswer);

	void deleteOffered_Answer(Offered_Answer offeredAnswer);

	void updateOffered_Answer(Offered_Answer offeredanswer);

}
