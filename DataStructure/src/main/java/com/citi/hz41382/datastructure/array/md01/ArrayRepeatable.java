package com.citi.hz41382.datastructure.array.md01;

import java.util.ArrayList;
import java.util.List;

/**
* @author hz41382 E-mail:fengandzhy@gmail.com
* @version createtime：2018年10月3日 上午10:34:12
* 可重复元素的数组
*/
public class ArrayRepeatable extends OperateByIndex{
	
	public ArrayRepeatable(){
		super();
	}
	
	public boolean removeByData(int data){
		int index = getIndex(0,data);
		if(index == -1){
			return false;			
		}
		while(index >=0){
			removeByIndex(index);
			index = getIndex(index, data);
		}		
		return true;
	}
	
	public List<Integer> searchAll(int data){
		List<Integer> retList = new ArrayList<>();		
		int index = getIndex(0,data);
		if(index == -1){
			return retList;			
		}
		while(index >=0){
			retList.add(datas[index]);
			index = getIndex(index+1, data);
		}
		return retList;
	}
	
	private int getIndex(int begin, int data){
		int index = -1;		
		for(int i=begin;i<currentIndex+1;i++){
			if(datas[i] == data){
				index = i;
				break;
			}
		}
		return index;
	}
}
