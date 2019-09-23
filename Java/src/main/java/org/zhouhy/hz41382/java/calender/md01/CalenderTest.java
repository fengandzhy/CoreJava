package org.zhouhy.hz41382.java.calender.md01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;



import org.junit.Test;

/**
 * 获得北京时间
 * */

public class CalenderTest {
	
	@Test
	public static void main(String args[]){
		 testCase2();
	}
	
	public static void testCase1(){
		TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormat.setTimeZone(timeZone);
		System.out.println(simpleDateFormat.format(new Date()));		
	}
	
	public static void testCase2(){
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		Calendar calendar1 = Calendar.getInstance(); 
		System.out.println(calendar1.getTimeInMillis());
		System.out.println(calendar.getTimeInMillis());
	}
}
