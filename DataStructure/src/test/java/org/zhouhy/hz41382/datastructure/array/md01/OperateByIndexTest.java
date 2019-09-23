package org.zhouhy.hz41382.datastructure.array.md01;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class OperateByIndexTest extends TestCase {

	OperateByIndex operateWithIndex;
	
	@Before
	public void setUp()throws Exception{
		operateWithIndex = new OperateByIndex();
	}
	
	@Test
	public void testInsertData1() {
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		operateWithIndex.insertData(3);
		operateWithIndex.insertData(2);
		operateWithIndex.insertData(1);		
		assertEquals(4,operateWithIndex.currentIndex);
		assertEquals(5,operateWithIndex.datas.length);
	}
	
	@Test
	public void testInsertData2() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		operateWithIndex.insertData(3);
		operateWithIndex.insertData(2);
		operateWithIndex.insertData(1);
		operateWithIndex.insertData(1);
		assertEquals(5,operateWithIndex.currentIndex);
		assertEquals(10,operateWithIndex.datas.length);		
	}
	
	@Test
	public void testRemoveByIndex1() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.removeByIndex(2);
		int data = operateWithIndex.datas[0];
		assertEquals(5,data);		
	}
	
	@Test
	public void testRemoveByIndex2() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		operateWithIndex.removeByIndex(1);
		Integer data = operateWithIndex.datas[0];
		assertEquals(5,data.intValue());
		data = operateWithIndex.datas[1];
		assertNull(data);
	}
	
	@Test
	public void testRemoveByIndex3() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		operateWithIndex.insertData(3);
		operateWithIndex.removeByIndex(1);
		Integer data = operateWithIndex.datas[0];
		assertEquals(5,data.intValue());
		data = operateWithIndex.datas[1];
		assertEquals(3,data.intValue());
	}
	
	@Test
	public void testRemoveByIndex4() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		operateWithIndex.insertData(3);
		operateWithIndex.insertData(4);
		operateWithIndex.insertData(3);
		operateWithIndex.insertData(4);	
		operateWithIndex.insertData(6);	
		operateWithIndex.removeByIndex(1);
		operateWithIndex.removeByIndex(1);
		Integer data = operateWithIndex.datas[0];
		assertEquals(5,operateWithIndex.datas.length);
		data = operateWithIndex.datas[1];
		assertEquals(4,data.intValue());
	}

	@Test
	public void testFindOneByIndex1() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		Integer data = operateWithIndex.findOneByIndex(2);
		assertNull(data);
	}
	
	@Test
	public void testFindOneByIndex2() {
		operateWithIndex = new OperateByIndex();
		operateWithIndex.insertData(5);
		operateWithIndex.insertData(4);
		Integer data = operateWithIndex.findOneByIndex(1);
		assertEquals(4,data.intValue());
	}
	
	
}
