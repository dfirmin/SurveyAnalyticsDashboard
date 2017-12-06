package com.sad.dto;

import java.io.Serializable;

public class Persons implements Serializable{
	private int personID;
	private String firstName;
	private String lastName;
	private String email;
	private String location;
	private int cohortID;
	
	public Persons(){
		
	}
	
	
	public Persons(int personID, String firstName, String lastName, String email, String location, int cohortID) {
		super();
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.cohortID = cohortID;
	}


	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCohortID() {
		return cohortID;
	}

	public void setCohortID(int cohortID) {
		this.cohortID = cohortID;
	}

	
}
