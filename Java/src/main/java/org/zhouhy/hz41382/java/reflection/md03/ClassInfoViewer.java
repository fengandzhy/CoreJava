package org.zhouhy.hz41382.java.reflection.md03;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
* <p>className: ClassDeclarationViewer</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月29日
*/
public class ClassInfoViewer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassInfoViewer.class);
	private ClassInfoViewer(){
		//empty
	}
	
	@Test
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("java.util.ArrayList");// 获得ArrayList类对象
		printClassInfo(clazz);
		printClassGenericInfo(clazz);
		printClassInterfaceInfo(clazz);
		printSuperClassInfo(clazz);
		printAnnotationInfo(clazz);
		printConstructorInfo(clazz);
		printFieldsInfo(clazz);
		printMethodInfo(clazz);
	}
	
	//获得类的信息
	public static void printClassInfo(Class<?> clazz){
		LOGGER.info("类的标准名称：" + clazz.getCanonicalName());
		LOGGER.info("clazz.getName()：" + clazz.getName());
		LOGGER.info("clazz.getSimpleName()：" + clazz.getSimpleName());
        LOGGER.info("类的修饰符：" + Modifier.toString(clazz.getModifiers()));
	}
	
	//获得泛型信息
	public static void printClassGenericInfo(Class<?> clazz){
		TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
		LOGGER.info("类的泛型参数：");
        if (typeVariables.length != 0) {
            for (TypeVariable<?> typeVariable : typeVariables) {
                LOGGER.info(typeVariable + "\t");
            }
        } else {
            LOGGER.info("空");
        }
	}
	
	// 输出类所实现的所有接口
	public static void printClassInterfaceInfo(Class<?> clazz){
		Type[] interfaces = clazz.getGenericInterfaces();
        LOGGER.info("类所实现的接口：");
        if (interfaces.length != 0) {
            for (Type type : interfaces) {
                LOGGER.info("\t" + type);
            }
        } else {
            LOGGER.info("\t" + "空");
        }
	}
	
	// 输出类的直接继承类，如果是继承自Object则返回空
	public static void printSuperClassInfo(Class<?> clazz){		
        Type superClass = clazz.getGenericSuperclass();
        LOGGER.info("类的直接继承类：");
        if (superClass != null) {
        	LOGGER.info(superClass.toString());
        } else {
        	LOGGER.info("空");
        }
	}
	
	// 输出类的所有注释信息，有些注释信息是不能用反射获得的
	public static void printAnnotationInfo(Class<?> clazz){
		 Annotation[] annotations = clazz.getAnnotations();
		 	LOGGER.info("类的注解：");
	        if (annotations.length != 0) {
	            for (Annotation annotation : annotations) {
	            	LOGGER.info("\t" + annotation);
	            }
	        } else {
	        	LOGGER.info("空");
	        }
	}
	
	// 输出构造器信息
	public static void printConstructorInfo(Class<?> clazz){
		Constructor<?>[] constructors = clazz.getConstructors();// 获得该类对象的所有构造方法
		LOGGER.info("类的构造方法：");
        if (constructors.length != 0) {
            for (Constructor<?> constructor : constructors) {
            	LOGGER.info("\t" + constructor);// 输出构造方法
            }
        } else {
        	LOGGER.info("\t空");
        }
	}	
	
	// 输出字段信息
	public static void printFieldsInfo(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();// 获得该类对象的所有非继承域
		LOGGER.info("类的非继承域变量：");
        if (fields.length != 0) {
            for (Field field : fields) {
            	LOGGER.info("\t" + field);// 输出非继承域
            }
        } else {
        	LOGGER.info("\t空");
        }
	}
	
	//輸出方法信息
	public static void printMethodInfo(Class<?> clazz){
		Method[] methods = clazz.getDeclaredMethods();// 获得该类对象的所有非继承方法
		LOGGER.info("类的非继承方法：");
        if (methods.length != 0) {
            for (Method method : methods) {
            	LOGGER.info(method.toString());// 输出非继承方法
            }
        } else {
        	LOGGER.info("\t空");
        }
	}
}
