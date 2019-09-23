package org.zhouhy.datastructure.array.disorder;
/**
* 用来演示直接使用数据操作无序数组,存放不重复的值
*/
public class OperateNoIndex {
	private int[] datas = null;
	private int currentIndex =-1;	
	
	public OperateNoIndex(int length) {
		datas = new int[length];
	}

	public int insert(int data){
		datas[currentIndex] = data;
		currentIndex++;
		return currentIndex;
	}
	
	private int getIndex(int begin,int data){
		int index =-1;
		for(int i=begin;i<currentIndex;i++){
			if(datas[i] == data){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void remove(int data){
		int index = getIndex(0,data);
		while(index>=0){
			for(int i=index;i<currentIndex;i++){
				datas[i] = datas[i+1];
			}
			currentIndex--;
			index = getIndex(index, data);
		}		
	}
	
	public int search(int data){
		int index = getIndex(0,data);
		if(index>=0){
			return datas[index];
		}
		return datas[index];
	}
	
	public void printDatas(){
		System.out.println("========================");
		for(int d:datas){
			System.out.print(d+",");
		}
	}
}
