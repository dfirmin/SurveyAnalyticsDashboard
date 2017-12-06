package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Cohort;



public interface CohortDao {
	
ArrayList<Cohort> getAllCohorts();
	
	void addCohort(Cohort newCohort);

	void deleteCohort(Cohort cohort);

	void updateCohort(Cohort cohort);

}
