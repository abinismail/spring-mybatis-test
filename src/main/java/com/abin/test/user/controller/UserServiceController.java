package com.abin.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abin.test.entity.PeopleEntity;
import com.abin.test.user.service.UserService;


@RestController("/Test")
public class UserServiceController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public String addNewUser() {

		PeopleEntity p = new PeopleEntity();
		p.setFirstName("Sahaf");
		p.setLastName("Ismail");
		p.setAge(23);
		p.setCompanyName("RR Downlley");
		
		System.out.println("Adding New User");
		userService.addNewUser(p);
		System.out.println("New User added successfully");
		
		
		System.out.println("Retrieving the user from Database");
		PeopleEntity saveduser = userService.searchUserUsingNames(p.getFirstName(), p.getLastName());
		System.out.println("Successfully retrieved");
		
		return "Added to database using MyBatis \n" + saveduser.toString();
	}
}
