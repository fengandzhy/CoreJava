package com.citi.hz41382.java.string.md01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringAPITest {
	private static final Logger LOGGER = LoggerFactory.getLogger(StringAPITest.class);
	private StringAPITest(){}
	
	@Test
	public static void main(String[] args) {
		//split();
		substring();
		
	}
	
	public static void split(){
		String str = "a,b,c,d";
		String[] strs = str.split(",", -1);//这里的3是数组的大小.
		print(strs);
	}
	
	public static void substring(){
		String str = "2+3+(4+5)*2";		
		System.out.println(str.indexOf("("));
		System.out.println(str.substring(5,8));
	}
	
	public static void print(String[] strs){
		for(String str:strs){
			LOGGER.info(str);
		}
	}

}
