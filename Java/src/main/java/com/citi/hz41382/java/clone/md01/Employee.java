package com.citi.hz41382.java.clone.md01;
/**
* <p>className: Employee</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月31日
*/
public class Employee {
	
	private String name;
    private int age;
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
    
	@Override
    public String toString() {
        return "姓名：" + name + ", 年龄：" + age;
    }
}
