package org.zhouhy.datastructure.array.disorder;
/**
* <p>通过索引操作无数数组</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年5月29日
*/
public class OperateWithIndex {
	private int[] datas = null;
	private int currentIndex =0;	
	
	public OperateWithIndex(int length) {
		datas = new int[length];
	}

	public int insert(int data){
		datas[currentIndex] = data;
		currentIndex++;
		return currentIndex-1;
	}
	
	public void remove(int index){
		for(int i=index;i<currentIndex;i++){
			datas[i]=datas[i+1];
		}
		currentIndex--;
	}
	
	public int search(int index){
		return datas[index];
	}
	
	public void printDatas(){
		System.out.println("========================");
		for(int d:datas){
			System.out.println(d);
		}
	}
}
