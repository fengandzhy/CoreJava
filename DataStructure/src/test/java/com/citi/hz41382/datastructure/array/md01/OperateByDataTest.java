package com.citi.hz41382.datastructure.array.md01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
* <p>Title: OperateByDataTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月3日
*/
public class OperateByDataTest {

	OperateByData operatebyData;
	
	@Before
	public void setUp() throws Exception {
		operatebyData = new OperateByData();
	}

	@Test
	public void testRemove1() {
		operatebyData.insertData(5);
		operatebyData.insertData(4);
		operatebyData.insertData(1);
		operatebyData.insertData(1);
		operatebyData.insertData(2);
		operatebyData.insertData(2);		
		boolean flag = operatebyData.remove(3);
		assertFalse(flag);		
	}
	
	@Test
	public void testRemove2() {
		operatebyData.insertData(5);
		operatebyData.insertData(4);
		operatebyData.insertData(1);
		operatebyData.insertData(1);
		operatebyData.insertData(2);
		operatebyData.insertData(2);
		assertEquals(10,operatebyData.datas.length);
		boolean flag = operatebyData.remove(2);
		assertTrue(flag);
		assertEquals(5,operatebyData.datas.length);
	}
	
	@Test
	public void testSearchOneByData1() {
		operatebyData.insertData(5);
		operatebyData.insertData(4);
		operatebyData.insertData(1);
		operatebyData.insertData(1);
		operatebyData.insertData(2);
		operatebyData.insertData(2);
		Integer data = operatebyData.searchOneByData(3);
		assertNull(data);		
	}
		
	
	@Test
	public void testSearchOneByData2() {
		operatebyData.insertData(5);
		operatebyData.insertData(4);
		operatebyData.insertData(1);
		operatebyData.insertData(1);
		operatebyData.insertData(2);
		operatebyData.insertData(2);
		Integer data = operatebyData.searchOneByData(2);
		assertNotNull(data);
		
	}
	
	public void test(){
		
	}
}
