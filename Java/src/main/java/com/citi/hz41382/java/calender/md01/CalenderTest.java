package com.citi.hz41382.java.calender.md01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;

/**
 * 获得北京时间
 * */

public class CalenderTest {
	
	@Test
	public static void main(String args[]){
		 testCase1();
	}
	
	public static void testCase1(){
		TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormat.setTimeZone(timeZone);
		System.out.println(simpleDateFormat.format(new Date()));		
	}
}
