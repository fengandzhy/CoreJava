package org.zhouhy.hz41382.java.reflection.md01;

import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: FieldTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
* getField(String name);这个是调用的是public的字段
* getDeclareField(String name);这个是调用的是全部字段不包含继承字段
*/
public class FieldTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(FieldTest.class);
	private FieldTest(){}	
	
	@Test
	public static void main(String[] args) {
		Student student = new Student();
		Address addr = new Address();
		addr.setCity("ShangHai");
		addr.setStreet("East Gu Bei Rd");
//		Class<?> clazz = student.getClass();
		Class<?> clazz = Student.class;
		LOGGER.info("class name is "+clazz.getName());		
		try {
			Field address = clazz.getDeclaredField("address");
			address.setAccessible(true);
			address.set(student, addr);
			LOGGER.info("Address is "+student.getAddress().getCity()+","+student.getAddress().getStreet());
			
			Field name = clazz.getDeclaredField("name");
			name.setAccessible(true);
			name.set(student, "Sam");
			LOGGER.info("Name is "+student.getName());
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
