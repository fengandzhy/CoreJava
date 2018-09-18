package com.citi.hz41382.java.exception.md01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 调用RuntimeException和非RuntimeException的区别
 * 调用非RuntimeException时，一定有throws
 * */
public class ThrowExceptionTest {	
	private static final Logger LOGGER = LoggerFactory.getLogger(ThrowExceptionTest.class);
	private ThrowExceptionTest(){}	
	
	@Test
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			throwRuntimeException();
		} catch (ArithmeticException e) {
			LOGGER.error("catch an ArithmeticException");
		}
		throwCheckedException();
	}
	
	public static void throwRuntimeException(){
		throw new ArithmeticException("Here is an ArithmeticException");
	}
	
	public static void throwCheckedException() throws ClassNotFoundException{
		throw new ClassNotFoundException("Here is an ClassNotFoundException");
	}
	
}
