package com.abin.test.user.service;

import com.abin.test.entity.PeopleEntity;

public interface UserService {
	
	public void addNewUser(PeopleEntity p);
	
	public PeopleEntity searchUserUsingNames(String firstName, String lastName); 

}
