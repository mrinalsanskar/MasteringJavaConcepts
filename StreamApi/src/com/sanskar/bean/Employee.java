package com.sanskar.bean;

public class Employee {
	
	  public long empId;
	  public String name;
	  private int age;
	  private String designation;
	  public long salary;


	public Employee(long empId, String name, int age, String designation, long salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
	}


	
	
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	  
	  

}
