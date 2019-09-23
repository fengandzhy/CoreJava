package org.zhouhy.hz41382.datastructure.stack.md01;
/**
* <p>className: MyStack</p>
* <p>Description: 栈基本操作演示 </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月4日
*/
public class MyStack {
	protected int[] datas;
	protected int topIndex =-1;
	
	public MyStack(int length){
		datas = new int[length];
	}
	
	public boolean push(int data){
		if(topIndex == datas.length-1){
			return false;
		}
		topIndex++;
		datas[topIndex]=data;
		return true;
	}
	
	public Integer pop(){
		if(topIndex==-1){
			return null;			
		}
		int top = datas[topIndex];
		topIndex--;
		return top;
	}
	
	public Integer peek(){
		if(topIndex==-1){
			return null;			
		}
		return datas[topIndex];
	}
	
	public boolean isEmpty(){
		return topIndex == -1;
	}
	
	public boolean isFull(){
		return topIndex==datas.length-1;
	}
}
