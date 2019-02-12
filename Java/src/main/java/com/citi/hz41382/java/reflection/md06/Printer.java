package com.citi.hz41382.java.reflection.md06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: Printer</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class Printer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);
	
	public static void staticPrint(){
		LOGGER.info("static print");
	}
	
	public static void staticPrint(String str){
		LOGGER.info("static print "+str);
	}
	
	public static void staticPrint(String str1,String str2){
		LOGGER.info("static print "+str1+","+str2);
	}
	
	public void print(){
		LOGGER.info("print with no peremeter");
	}
	
	public void print(String str){
		LOGGER.info("print with peremeter "+str);
	}
	
	public void print(String str1,String str2){
		LOGGER.info("print with peremeters "+str1+","+str2);
	}
	
	public void callPrivate(){
		privatePrint();
	}
	
	private void privatePrint(){
		LOGGER.info("private print");
	}
}
