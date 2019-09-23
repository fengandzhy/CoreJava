package org.zhouhy.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.function.DoubleUnaryOperator;

/**
* <p>className: TimeTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年4月17日
*/
public class TimeTest {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
		test6();
	}
	
	public static void test1(){
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);		
	}
	
	public static void test2(){
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d  Month : %d  day : %d  %n", year, month, day);
	}
	
	public static void test3(){
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);
	}
	
	public static void test4(){
		LocalDate date1 = LocalDate.of(2014, 01, 14);
		LocalDate today = LocalDate.now();
		if(date1.equals(today)){
		    System.out.printf("Today %s and date1 %s are same date %n", today, date1);
		}
	}
	
	public static void test5(){
		LocalDate today = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		 
		if(currentMonthDay.equals(birthday)){
		   System.out.println("Many Many happy returns of the day !!");
		}else{
		   System.out.println("Sorry, today is not your birthday");
		}
	}
	
	public static void test6(){
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);		
	}
	
	

}
