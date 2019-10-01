/**
 * 
 */
package com.abin.test.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.abin.test.entity.PeopleEntity;

/**
 * @author abin
 *
 */

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO people (first_name, last_name, age, company_name)"
			+ " VALUES (#{firstName},#{lastName}, #{age}, #{companyName})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public void addUser(PeopleEntity user);

	@Select("SELECT first_name as firstName, last_name as lastName, age, company_name as companyName"
			+ " FROM people"
			+ " WHERE id=#{id}")
	public PeopleEntity getUserById(int id);
	
	@Select("SELECT first_name as firstName, last_name as lastName, age, company_name as companyName"
			+ " FROM people"
			+ " WHERE first_name=#{firstName} AND last_name=#{lastName}")
	public PeopleEntity getUserByFirstAndLastName(String firstName, String lastName);
	
	@Select("SELECT id, first_name as firstName, last_name as lastName, age, company_name as companyName"
			+ " FROM people")
	public List<PeopleEntity> getAllUsers();
	
	@Delete("DELETE FROM people WHERE first_name=#{firstName} AND last_name=#{lastName}")
	public void deleteUserByName(String firstName, String lastName);
	
	@Delete("DELETE FROM people WHERE id=#{id}")
	public void deleteUserById(int id);
	
	@Delete("DELETE FROM people WHERE company_name=#{companyName}")
	public void deleteUserByCompany(String companyName);
}
