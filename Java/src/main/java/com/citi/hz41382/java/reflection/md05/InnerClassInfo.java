package com.citi.hz41382.java.reflection.md05;

import java.awt.geom.Point2D;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.hz41382.java.reflection.md03.ClassInfoViewer;

/**
* <p>className: InnerClassInfo</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class InnerClassInfo {
	private static final Logger LOGGER = LoggerFactory.getLogger(InnerClassInfo.class);
	
	private InnerClassInfo(){
		//empty
	}
	
	@Test
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cls = Point2D.class;
        Class<?>[] classes = cls.getDeclaredClasses();// 获得代表内部类的Class对象组成的数组
        LOGGER.info("printing classes infomation!!");
        for(Class<?> clazz:classes){
        	ClassInfoViewer.printAnnotationInfo(clazz);
        	ClassInfoViewer.printClassGenericInfo(clazz);
        	ClassInfoViewer.printClassInfo(clazz);
        	ClassInfoViewer.printClassInterfaceInfo(clazz);
        	ClassInfoViewer.printConstructorInfo(clazz);
        	ClassInfoViewer.printFieldsInfo(clazz);
        	ClassInfoViewer.printMethodInfo(clazz);
        	ClassInfoViewer.printSuperClassInfo(clazz);
        }
	}

}
