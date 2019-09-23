package org.zhouhy.hz41382.java.reflection.md02;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* <p>className: ClassTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月29日
*/
public class ClassTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassTest.class);
	
	private ClassTest() {
		//empty
	}
	
	@Test
	public static void main(String[] args) throws ClassNotFoundException {
		LOGGER.info("第1种方法：Object.getClass()");
        Class<? extends Date> c1 = new Date().getClass();// 使用getClass()方式获得Class对象
        LOGGER.info(c1.getName());// 输出对象名称
        LOGGER.info("第2种方法：.class语法");
        Class<Boolean> c2 = boolean.class;// 使用.class语法获得Class对象
        LOGGER.info(c2.getName());// 输出对象名称
        LOGGER.info("第3种方法：Class.forName()");
        Class<?> c3 = Class.forName("java.lang.String");// 使用Class.forName()获得Class对象
        LOGGER.info(c3.getName());// 输出对象名称
        LOGGER.info("第4种方法：包装类的TYPE域");
        Class<Double> c4 = Double.TYPE;// 使用包装类获得Class对象
        LOGGER.info(c4.getName());// 输出对象名称
        
        String dateName = new Date().getClass().getName();// 获得引用类型名称
        LOGGER.info("非数组引用类型的名称：" + dateName);// 输出引用类型名称
        String byteName = byte.class.getName();// 获得原始类型名称
        LOGGER.info("基本类型的名称：" + byteName);// 输出原始类型名称
        String oneDimensionArray = new Date[4].getClass().getName();// 获得一维引用类型数组
        LOGGER.info("一维引用类型数组：" + oneDimensionArray);// 输出一维引用类型数组名称
        String twoDimensionArray = new int[4][4].getClass().getName();// 获得二维原始类型
        LOGGER.info("二维基本类型数组：" + twoDimensionArray);// 输出二维引用类型数组名称
	}

}
