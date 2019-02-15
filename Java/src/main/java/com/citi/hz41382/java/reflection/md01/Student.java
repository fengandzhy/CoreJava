package com.citi.hz41382.java.reflection.md01;
/**
* <p>className: Student</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class Student {
	private String name;
	private double id;
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}	
}
