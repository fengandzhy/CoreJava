package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ScannerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScannerTest.class);
	
	
	@Test
	public static void main(String[] args) {		
		Scanner scn = new Scanner(System.in);
		ArrayList<String> array = addInput(scn);
		processInput(array);
		scn.close();
	}
	
	public static ArrayList<String> addInput(Scanner scn){		
		ArrayList<String> array = new ArrayList<String>();
		String line;
		while (!"end".equals(line = scn.nextLine())) {
			array.add(line);			
		}
		return array;
	}
	
	public static void processInput(ArrayList<String> array){
		int sum =0;
		for (String str : array){
			sum +=  addNumber(str.split(","));
		}
		LOGGER.info("The resutle is "+String.valueOf(sum));
	}
	
	public static int addNumber(String[] strArray){
		int sum = 0;		
		for(String a1 : strArray){
			sum=getResult(sum,a1);						
		}
		return sum;
	}
	
	public static int getResult(int sum,String a1){
		try {
			int a2 = processNegativeNumber(processLargerThanOneThound(Integer.parseInt(a1)));
			sum += a2;
		} catch (NumberFormatException e) {
//			LOGGER.error("Invalid input "+a1);
//			return 0;
			e.printStackTrace();
		}
		return sum;
	}
	
	public static int processLargerThanOneThound(int number){
		if(number >= 1000){
			return 0;
		}
		return number;
	}
	
	public static int processNegativeNumber(int number){
		if(number < 0){
			return 0;
		}
		return number;
	}
}
