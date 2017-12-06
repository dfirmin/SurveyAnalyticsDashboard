package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Persons;

public interface PersonsDao {
	
ArrayList<Persons> getAllPersons();
	

	void addPersons(Persons newPerson);

	void deletePersons(Persons person);

	void updatePersons(Persons person);

}
