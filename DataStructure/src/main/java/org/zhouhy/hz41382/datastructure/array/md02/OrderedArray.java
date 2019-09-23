package org.zhouhy.hz41382.datastructure.array.md02;

import java.util.ArrayList;
import java.util.List;

/**
* <p>Title: OrderedArray</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月3日
*/
public class OrderedArray {
	
	protected Integer[] datas = null;
	protected int currentIndex = -1;
	private boolean orderRule; //排序规则true为升序false为降序
	private int length = 5;
	
	
	public OrderedArray(boolean orderRule){
		datas = new Integer[length];
		this.orderRule = orderRule;
	}
	
	
	public void insertData(int data){		
		if(currentIndex+1 == length){
			changeArrayLength(true);
		}
		//先查出index
		int index = getIndexByBinarySearch(data);
		
		for(int i=currentIndex;i>=index;i--){
			datas[i+1] = datas[i];
		}
		datas[index] = data;
		currentIndex++;
	}
	
	public List<Integer> findAllByBinarySearch(int data){
		List<Integer> retList = new ArrayList<>();
		int index = -1;
		Integer beginIndex = 0;
		Integer endIndex = currentIndex;
		while(true){
			if(beginIndex>endIndex){
				return retList;
			}
			if(beginIndex == endIndex){
				if(datas[beginIndex] == data){
					getDatas(beginIndex,data,retList);
					return retList;
				}else{
					return retList;
				}
			}
			index = (beginIndex+endIndex)/2;
			if(datas[index] == data){
				getDatas(index,data,retList);
				return retList;
			}			
			endIndex = getEndIndex(index,data,endIndex);
			beginIndex = getBeginIndex(index,data,beginIndex);
		}
	}
	
	/**
	 * 
	 * <p>Title: getIndexByBinarySearch</p>
	 * <p>Description: 二分法插入数据</p>
	 * @param data 
	 * @return
	 * 在一个有序数组中插入一个数组使得数组继续保持有序，那么就需要找一个合适的位置来插入数据
	 * 二分法的意思就是通过不断地缩小范围来最终找到这个合适的位置.
	 * 要不断地缩小范围，首先就要有一个起始范围，这个范围必然是整个数组,取这个数组中间的那个元素
	 * 和要插入的数据比较，然后再次进行范围判断.
	 * 每次比较只有两个结果，要么beginIndex=index +1; 要么endIndex = index-1;
	 * 那么最终缩小范围的结果只有两个要么最终 beginIndex==endIndex，要么beginIndex>endIndex
	 * 所以最终只对这两种情况进行判断即可,为了减小循环的次数，如果一旦datas[index] == data，直接返回 
	 * 
	 */
	private int getIndexByBinarySearch(int data){
		int index=0;
		Integer beginIndex = 0;
		Integer endIndex = currentIndex;
		while(true){			
			if(beginIndex==endIndex){
				index = getIndex(data, beginIndex);	
				return index;
			}
			if(beginIndex>endIndex){
				return beginIndex;
			}			
			index = (beginIndex+endIndex)/2;
			if(datas[index] == data){
				return index;
			}
			endIndex = getEndIndex(index,data,endIndex);
			beginIndex = getBeginIndex(index,data,beginIndex);			
		}		
	}
	
	private void getDatas(int index, int data, List<Integer> retList){
		retList.add(datas[index]);
		for(int i =index-1;i>-1;i--){
			if(datas[i]!=data){
				break;
			}
			retList.add(datas[index]);
		}		
		for(int i =index+1;i<currentIndex;i++){
			if(datas[i]!=data){
				break;
			}
			retList.add(datas[index]);
		}
	}
	
	private int getEndIndex(int index,int data,int endIndex){
		if(datas[index]>data && orderRule){	
			return index-1;				
		}
		if(datas[index]<data && !orderRule){	
			return index-1;				
		}
		return endIndex;
	}
	
	private int getBeginIndex(int index,int data,int beginIndex){
		if(datas[index]>data && !orderRule){	
			return index+1;				
		}
		if(datas[index]<data && orderRule){	
			return index+1;				
		}
		return beginIndex;
	}
	
	private int getIndex(int data, int beginIndex){
		if(data<=datas[beginIndex] && orderRule){
			return beginIndex;
		}		
		if(data>datas[beginIndex] && orderRule){
			return  beginIndex+1;
		}
		
		if(data<=datas[beginIndex] && !orderRule){
			return beginIndex+1;
		}		
		return beginIndex;		
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
	
	public void printData(){
		for(int i = 0;i<datas.length;i++){
			System.out.print(datas[i]+",");
			if(i%10==9){
				System.out.println("");
			}
		}		
	}
}
