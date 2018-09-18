package com.citi.hz41382.java.common;

import org.junit.Test;

public class StringUtils {
	
	private StringUtils(){
		
	}
	
	/**
	 * 判断是否为空
	 * @author hz41382
	 * 2018-07-03
	 * */
	public static boolean isBlank(String string){
		if (null==string || string.length()==0){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为整数字
	 * @author hz41382
	 * 2018-07-03
	 * */
	public static boolean isDigit(String str){
		String str1 = str.trim();
		for (int i = 0; i < str1.length(); i++) {
			char charAt = str1.charAt(i);
			 if (!Character.isDigit(charAt)) {
				 return false;
			 }
		}
		return true;
	}	
	
	@Test
	public static void main(String args[]){
		System.out.println(isDigit("21211"));
	}
}
