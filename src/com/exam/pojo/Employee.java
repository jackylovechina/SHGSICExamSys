package com.exam.pojo;

public class Employee {

	private long ID;
	private long Role_ID;
	private long Dep_ID;
	private String Name;
	private String Number;
	private String Sex;
	private String Password;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getRole_ID() {
		return Role_ID;
	}

	public void setRole_ID(long role_ID) {
		Role_ID = role_ID;
	}

	public long getDep_ID() {
		return Dep_ID;
	}

	public void setDep_ID(long dep_ID) {
		Dep_ID = dep_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
