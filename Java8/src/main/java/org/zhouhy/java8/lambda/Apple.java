package org.zhouhy.java8.lambda;
/**
* <p>className: Apple</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月19日
*/
public class Apple {	
	private String color;
	private double weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	public Apple(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}	
}
