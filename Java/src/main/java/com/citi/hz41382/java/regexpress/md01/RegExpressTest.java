package com.citi.hz41382.java.regexpress.md01;

import org.junit.Test;

public class RegExpressTest {

	private RegExpressTest(){
		
	}
	
	@Test
	public static void main(String[] args) {
		System.out.println(checkNumber("-23.01"));
		System.out.println(checkNumber("3"));
		System.out.println(checkNumber("-0.00100"));
		System.out.println(checkPassword("Xiaoxiong211610&"));
		System.out.println(checkPassword("Xiao&xiong2116&10"));
		System.out.println(checkPassword("Xiao_xiong2116&10bbbb"));
		System.out.println(checkEmail("fengandzhy@126.com"));
		System.out.println(checkEmail("fengandzhy@126.co.nz"));
	}
	
	/**
	 * 判断数字
	 * */
	public static boolean checkNumber(String value){
		String regex = "^(-?[1-9]\\d*\\.?\\d*)|(0\\.\\d*)|([0])|(-0\\.\\d*[1-9]\\d*)$";
		return value.matches(regex);
	}
	
	/**
	 * 判断密码强度12-18位,字母数特殊字母字组合
	 * 
	 * 
	 * */
	public static boolean checkPassword(String password){
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{12,18}$";
		return password.matches(regex);
	}
	
	/**
	 * Email的规则: name@domain
	 * name最长64，domain最长253，总长最长256
	 * name可以使用任意ASCII字符
	 * 大小写英文字母 a-z,A-Z
	 * 数字 0-9
	 * 字符 !#$%&'*+-/=?^_`{|}~
	 * 字符 .不能是第一个和最后一个，不能连续出现两次
	 * 但是有些邮件服务器会拒绝包含有特殊字符的邮件地址
	 * domain仅限于26个英文字母、10个数字、连词号-
	 * 连词号-不能是第一个字符
	 * 顶级域名（com、cn等）长度为2到6个
	 * 
	 * 
	 * */	
	public static boolean checkEmail(String email){
		String regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
		return email.matches(regex);
	}
	
	

}
