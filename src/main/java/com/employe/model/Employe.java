package com.employe.model;

public class Employe {
	
	private String fname;
	private String lname;
	private int age;
	private int id;
	
	public Employe() {
		super();
	}
	
	public Employe(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	public Employe(String fname, String lname, int age, int id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employe [fname=" + fname + ", lname=" + lname + ", age=" + age + ", id=" + id + "]";
	}

	
	
	
}
