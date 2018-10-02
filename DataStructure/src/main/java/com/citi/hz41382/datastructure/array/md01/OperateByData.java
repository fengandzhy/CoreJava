package com.citi.hz41382.datastructure.array.md01;

public class OperateByData extends OperateByIndex{
		
	public OperateByData(){
		super();
	}
	
	public boolean remove(int data){
		int index = getIndex(data);
		if(index ==-1){
			return false;
		}
		removeByIndex(index);		
		return true;
	}
	
	private int getIndex(int data){
		int index = -1;
		for(int i=0;i<currentIndex+1;i++){
			if(datas[i] ==data){
				index = i;
				break;
			}
		}
		return index;
	}	
}
