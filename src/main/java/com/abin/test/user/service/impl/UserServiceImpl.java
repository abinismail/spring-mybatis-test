package com.abin.test.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abin.test.entity.PeopleEntity;
import com.abin.test.user.dao.UserMapper;
import com.abin.test.user.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addNewUser(PeopleEntity p) {
		System.out.println("In Service : addNewUser : Entry");
		userMapper.addUser(p);
		System.out.println("In Service : addNewUser : Exit");
	}

	@Override
	public PeopleEntity searchUserUsingNames(String firstName, String lastName) {
		return userMapper.getUserByFirstAndLastName(firstName, lastName);
	}
	
	

}
