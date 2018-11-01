package com.anish.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="nnishdb")
public class Employee
{
	@Id
	private Integer id;
	private String ename;
	private  double sal;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public double getSal() {
		return sal;
	}



	public void setSal(double sal) {
		this.sal = sal;
	}



	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(Integer id, String ename, double sal) {
		super();
		this.id = id;
		this.ename = ename;
		this.sal = sal;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", sal=" + sal + "]";
	}

}
