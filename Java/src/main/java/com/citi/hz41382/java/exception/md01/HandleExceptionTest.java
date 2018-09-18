package com.citi.hz41382.java.exception.md01;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HandleExceptionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(HandleExceptionTest.class);
	
	private HandleExceptionTest(){}
	
	@Test
	public static void main(String[] args) {
		Scanner scnner = new Scanner(System.in);
		ArrayList<String> array = new ArrayList<String>();
		String line;
		while(!"end".equals(line = scnner.nextLine())){
			array.add(line);
		}
		scnner.close();
		print(array);
	}
	
	public static void print(ArrayList<String> array){
		for(String element : array){
			try {
				double digital = Double.parseDouble(element);
				LOGGER.info(String.valueOf(digital));
			} catch (NumberFormatException e) {
				LOGGER.error("ERROR:"+e);
//				e.printStackTrace(); 这里也将继续运行程序
//				throw e; //throw了证明程序要停止了			
			}
		}
	}

}
