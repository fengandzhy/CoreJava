package com.citi.hz41382.java.comparator.md01;
/**
* <p>className: Player</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class Player {
	
	private int ranking;
    private String name;
    private int age;
    
    public Player(int ranking,String name,int age){
    	this.ranking = ranking;
    	this.name = name;
    	this.age = age;
    }
    
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
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
}
