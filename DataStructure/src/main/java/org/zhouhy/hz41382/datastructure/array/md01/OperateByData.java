package org.zhouhy.hz41382.datastructure.array.md01;

public class OperateByData extends OperateByIndex{
		
	public OperateByData(){
		super();
	}
	/**
	 * 
	 * <p>Title: remove</p>
	 * <p>Description: </p>
	 * @param data
	 * @return
	 */
	public boolean remove(int data){
		int index = getIndex(data);
		if(index ==-1){
			return false;
		}
		removeByIndex(index);		
		return true;
	}
	
	public Integer searchOneByData(int data){
		int index = getIndex(data);
		if(index<0){
			return null;
		}
		return datas[index];
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
