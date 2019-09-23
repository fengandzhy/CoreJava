package org.zhouhy.hz41382.java.reflection.md07;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* <p>className: DynamicArray</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class DynamicArrayTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicArrayTest.class);
	
	private DynamicArrayTest(){
		//empty
	}
	
	@Test
	public static void main(String args[]){
		int[] intArray = new int[10];
		LOGGER.info("整型数组原始长度是：" + intArray.length);
        Arrays.fill(intArray, 8);
        LOGGER.info("整型数组的内容：");
        LOGGER.info(Arrays.toString(intArray));
        int[] newIntArray = (int[]) increaseArray(intArray);
        LOGGER.info("整型数组扩展后长度是：" + newIntArray.length);
        LOGGER.info("整型数组的内容：");
        LOGGER.info(Arrays.toString(newIntArray));
        
        List<String> list = new ArrayList<>();
        Class<?> clazz = list.getClass();
        LOGGER.info(""+clazz.isArray());//false
	}
	
	public static Object increaseArray(Object array) {
		Class<?> clazz = array.getClass();// 获得代表数组的Class对象
		if (clazz.isArray()) {// 如果输入是一个数组
			Class<?> componentType = clazz.getComponentType();// 获得数组元素的类型
			int length = Array.getLength(array);// 获得输入的数组的长度
			Object newArray = Array.newInstance(componentType, length + 5);// 新建数组
			System.arraycopy(array, 0, newArray, 0, length);// 复制原来数组中的所有数据
			return newArray;// 返回新建数组
		}		
		return null;
	}
}
