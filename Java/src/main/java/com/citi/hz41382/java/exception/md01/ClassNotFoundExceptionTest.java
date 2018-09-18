package com.citi.hz41382.java.exception.md01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassNotFoundExceptionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassNotFoundExceptionTest.class);
	private ClassNotFoundExceptionTest(){}
	@Test
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql1.jdbc.Driver");// 加载MySQL驱动程序			
		} catch (ClassNotFoundException e) {// 捕获异常
			LOGGER.error("ERROR:"+e);
		}
		LOGGER.info("After Exception!!");
		
	}

}
