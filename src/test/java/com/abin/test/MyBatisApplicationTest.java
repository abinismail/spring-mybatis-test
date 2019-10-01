/**
 * 
 */
package com.abin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abin.test.entity.PeopleEntity;
import com.abin.test.user.dao.UserMapper;

/**
 * @author abin
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MyBatisApplicationTest {
 
	@Autowired
	private UserMapper userMapper;

	@Test
	public void findUserByIdTest() {
		PeopleEntity p = userMapper.getUserById(1);
		System.out.println(p.toString());
		assertEquals(p.getFirstName(), "Abin");

	}

	@Test
	public void finduserByNamesTest() {
		PeopleEntity p = 
				userMapper.getUserByFirstAndLastName("Abin", "Ismail");
		System.out.println("Find User By Name ------ \n"+p.toString());
		assertEquals(p.getFirstName(), "Abin");
	}
	
	@Test
	public void insertUserTest() {
		PeopleEntity p = getUserToAdd();
		userMapper.addUser(p);
		
		PeopleEntity addedUser = userMapper.getUserByFirstAndLastName(p.getFirstName(), p.getLastName());
		System.out.println("Added User \n"+addedUser.toString());
		
		assertEquals(p.getFirstName(), addedUser.getFirstName());
	}

	private PeopleEntity getUserToAdd() {
		PeopleEntity p = new PeopleEntity();
		p.setFirstName("Sahaf");
		p.setLastName("Ismail");
		p.setAge(23);
		p.setCompanyName("RR Downlley");
		return p;
	}
	
	@Test
	public void deleteUserByNameTest() {
		userMapper.deleteUserByName("ALAN", "ANIYAN");
		
		PeopleEntity p = userMapper.getUserByFirstAndLastName("ALAN", "ANIYAN");
		
		if(p != null) {
			System.out.println(p.toString());
		}
		
		assertNull(p);
	}

}
