package com.sad.dao;

import java.util.ArrayList;

import com.sad.dto.Users;

public interface UsersDao {
	
ArrayList<Users> getAllUsers();
	
	

	void addUsers(Users newUser);

	void deleteUsers(Users user);

	void updateUsers(Users user);



	ArrayList<Users> getAllUsers(String column, String str);

}
