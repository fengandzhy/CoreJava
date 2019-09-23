package org.zhouhy.hz41382.java.reflection.md06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: MethodInvokeTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class MethodInvokeTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodInvokeTest.class);
	
	private MethodInvokeTest(){
		//empty
	}
	
	@Test
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> clazz = Printer.class;
		invokeStaticMethod(clazz);
		invokePublicMethod(clazz);
		invokePrivateMethod(clazz);
	}
	
	//静态方法调用
	public static void invokeStaticMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		LOGGER.info("invoke static method test");
		Class<?>[] parameterTypes = new Class[]{};
		Object[] args = new Object[]{};
		Method method = clazz.getDeclaredMethod("staticPrint", parameterTypes);
		method.invoke(null, args);
		
		parameterTypes = new Class[]{String.class};
		args = new Object[]{"zhy"};
		method = clazz.getDeclaredMethod("staticPrint", parameterTypes);
		method.invoke(null, args);
		
		parameterTypes = new Class[]{String.class,String.class};
		args = new Object[]{"zhy","wpg"};
		method = clazz.getDeclaredMethod("staticPrint", parameterTypes);
		method.invoke(null, args);
	}
	
	public static void invokePublicMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		LOGGER.info("invoke public method test");
		Printer printer = new Printer();
		Class<?>[] parameterTypes = new Class[]{};
		Object[] args = new Object[]{};
		Method method = clazz.getDeclaredMethod("print", parameterTypes);
		method.invoke(printer, args);
		
		parameterTypes = new Class[]{String.class};
		args = new Object[]{"zhy"};
		method = clazz.getDeclaredMethod("print", parameterTypes);
		method.invoke(printer, args);
		
		parameterTypes = new Class[]{String.class,String.class};
		args = new Object[]{"zhy","wpg"};
		method = clazz.getDeclaredMethod("print", parameterTypes);
		method.invoke(printer, args);
	}
	
	public static void invokePrivateMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		LOGGER.info("invoke private method test");
		Printer printer = (Printer) clazz.newInstance();
		Class<?>[] parameterTypes = new Class[]{};
		Object[] args = new Object[]{};
		Method method = clazz.getDeclaredMethod("privatePrint", parameterTypes);
		method.setAccessible(true);
		method.invoke(printer, args);		
	}
}
