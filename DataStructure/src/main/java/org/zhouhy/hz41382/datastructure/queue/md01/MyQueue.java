package org.zhouhy.hz41382.datastructure.queue.md01;
/**
* <p>className: MyQueue</p>
* <p>Description: 队列基本操作</p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月6日
*/
public class MyQueue {
	private int[] queue;
	private int beginIndex =0;
	private int endIndex =-1;
	private int items =0;
	
	public MyQueue(int length){
		queue = new int[length];
	}
	
	public boolean insert(int data){
		//如果数组已满，无法添加
		if(items == queue.length){
			return false;
		}
		//如果endIndex已经在数组的最后一位元素了，在插入队列,那么就直接从新计数
		if(endIndex == queue.length-1){
			endIndex = -1;
		}		
		endIndex++;
		items++;
		queue[endIndex] = data;
		return true;
	}
	
	public boolean remove(){
		if(items == 0){
			return false;
		}		
		if(beginIndex == queue.length-1){
			beginIndex = 0;
		}
		beginIndex++;
		items--;
		return true;		
	}
	
	public int[] getDatas(){
		return queue;
	}
}
