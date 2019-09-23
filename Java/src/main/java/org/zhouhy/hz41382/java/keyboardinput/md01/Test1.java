package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
* <p>className: InputArrayTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月11日
*/
public class Test1 {

	public static void main(String[] args) {
		int firstarray[]=new int[11]; 
		int secondarray[]=new int[11];
		Scanner arr=new Scanner(System.in);
		getInputArray(arr,firstarray,secondarray);	
		boolean flag = getResult(firstarray,secondarray);
		if(flag){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		arr.close();
	}
	
	private static void getInputArray(Scanner arr,int firstarray[],int secondarray[]){		
		for(int i=0;i<firstarray.length;i++){
			firstarray[i]=arr.nextInt();
		}		
		for(int i=0;i<secondarray.length;i++){
			secondarray[i]=arr.nextInt();
		}
	}
	
	private static boolean getResult(int firstarray[],int secondarray[]){
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int i=0;i<firstarray.length;i++){
			list1.add(firstarray[i]);
		}
		for(int i=0;i<secondarray.length;i++){
			list2.add(secondarray[i]);
		}
		Iterator<Integer> iterator = list1.iterator();
		while(iterator.hasNext()){
			int number = iterator.next();
			boolean flag = false;
			for(int i =0;i<list2.size();i++){
				if(number == list2.get(i)){
					list2.remove(i);
					flag = true;
					break;
				}				
			}
			if(!flag){
				return flag;
			}
		}		
		return true;
	}
	
	

}
