package com.citi.hz41382.java.exception.md02;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerExceptionTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerExceptionTest.class);
	
	@Test
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setAge(30);
		try {
			testException(customer);
		} catch (Exception e) {
//			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
	}
	
	public static void testException(Customer customer){
		if(customer.getAge()>25){
			throw new CustomerException("14000001","Customer's age is older than 25");
		}
	}

}
