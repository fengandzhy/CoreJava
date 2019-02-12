package com.citi.hz41382.java.model.creator.demo01.client;

import org.junit.Test;

import com.citi.hz41382.java.model.creator.demo01.director.Director;
import com.citi.hz41382.java.model.creator.demo01.product.Computer;

public class CreatorClient {
	private CreatorClient(){}
	
	@Test
	public static void main(String args[]){
		Director director = new Director();
		Computer computer = director.constructComputer();
	}
}
