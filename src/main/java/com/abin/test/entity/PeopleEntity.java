/**
 * 
 */
package com.abin.test.entity;

import java.io.Serializable;

/**
 * @author abin
 *
 */

public class PeopleEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String companyName;
	
	public PeopleEntity() {
		
	}
	
	public PeopleEntity(String fName, String lName, int ag, String cName) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = ag;
		this.companyName = cName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PeopleEntity)) {
			return false;
		}
		PeopleEntity other = (PeopleEntity) obj;
		if (age != other.age) {
			return false;
		}
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "User -- \n"
				+ "ID : "+this.getId()+"\n"
				+ "First Name : "+this.firstName+"\n"
				+ "Last Name : "+this.lastName+"\n"
				+ "Age : "+this.age+"\n"
				+ "Company Name : "+this.companyName+"\n";
	}

}
