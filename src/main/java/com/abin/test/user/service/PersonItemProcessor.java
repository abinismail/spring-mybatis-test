package com.abin.test.user.service;

import org.springframework.batch.item.ItemProcessor;

import com.abin.test.entity.PeopleEntity;

public class PersonItemProcessor implements ItemProcessor<PeopleEntity, PeopleEntity> {

	@Override
	public PeopleEntity process(PeopleEntity item) throws Exception {
		final String firstName = item.getFirstName().toUpperCase();
		final String lastName = item.getLastName().toUpperCase();
		final String companyName = item.getCompanyName().toUpperCase();
		final int age = item.getAge();

		final PeopleEntity transformedPerson = 
				new PeopleEntity(firstName, lastName, age, companyName);
		
		System.out.println("Person Object converted and transformed");
		
		return transformedPerson;
	}

}
