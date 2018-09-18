package com.citi.hz41382.java.keyboardinput.md01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class KeyBoradReader {	
	private static final Logger LOGGER = LoggerFactory.getLogger(KeyBoradReader.class);
	
	private KeyBoradReader(){}	
	
	@Test
	public static void main(String[] args) {
		readSingalLine();
//		readMultipleLine();
	}
	
	public static void readSingalLine(){
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = buf.readLine();
			LOGGER.info(str);
		} catch (IOException e) {
			LOGGER.error("IOException" + e + e.getMessage());
			
		}
	}
	
	/**
	 * 读一行与读多行的区别就在于那个循环
	 * */
	public static void readMultipleLine(){
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> array = new ArrayList<>();	
		try {
			String line;
			while (!"end".equals(line = buf.readLine())) {
				array.add(line);	
			}			
		} catch (IOException e) {
			LOGGER.error("IOException" + e + e.getMessage());			
		}
		for(String element : array){
			LOGGER.info(element);
		}
	}
	
}
