package com.citi.hz41382.datastructure.array.md01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	
	
}
