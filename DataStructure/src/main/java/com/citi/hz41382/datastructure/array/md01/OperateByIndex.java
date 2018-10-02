package com.citi.hz41382.datastructure.array.md01;

/**
 * 无序数组
 * */
public class OperateByIndex {	
	protected Integer[] datas = null;
	protected int currentIndex = -1;
	private int length = 5;
	
	public OperateByIndex(){
		datas = new Integer[length];
	}
	
	public void insertData(int data){
		if(currentIndex+1 == length){
			changeArrayLength(true);
		}
		datas[currentIndex+1] = data;		
		currentIndex++;
	}
	
	public void removeByIndex(int index){		
		if(index > currentIndex){
			System.out.println("index is greater than currentIndex");
			return;
		}
		if(index == currentIndex){
			datas[index] = null;			
		}else{
			for(int i=index;i<currentIndex+1;i++){
				datas[i] = datas[i+1];
			}
		}	
		currentIndex--;
		if(currentIndex+1==length-5){
			changeArrayLength(false);
		}
	}
	
	public Integer findOneByIndex(int index){
		if(index > currentIndex){
			System.out.println("index is greater than currentIndex");
			return null;
		}
		return datas[index];
	}
	
	private void changeArrayLength(boolean flag){
		if(flag){
			length = length + 5;			
		}else{
			length = length - 5;	
		}
		Integer[] temArray= new Integer[length];
		System.arraycopy(datas, 0, temArray, 0, currentIndex+1 );
		datas = temArray;		
	}
}
