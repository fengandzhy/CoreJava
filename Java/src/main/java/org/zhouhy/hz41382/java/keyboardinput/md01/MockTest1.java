package org.zhouhy.hz41382.java.keyboardinput.md01;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
* <p>className: MockTest1</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class MockTest1 {
	public static void main(String[] args){
		ArrayList<String> array = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		while (true) {
            String nextLine = scan.nextLine();
            if (null==nextLine || nextLine.trim().length() == 0) {               
                break;
            }
            array.add(nextLine);
        }		
		List<String> list = processList(array);
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String item = iter.next();
			System.out.println(item);
		}
		scan.close();
	}
	
	public class PlayerAgeComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {			
			return 0;
		}
		
	}
	
	public static List<String> processList(ArrayList<String> array ){
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = array.iterator();
		while(iter.hasNext()){
			String item = iter.next();
			insertList(list,item);
		}		
		return list;
	}
	
	public static void insertList(ArrayList<String> list,String item){		
		if(list.size()==0){
			list.add(item);
			return;
		}
		Iterator<String> iter = list.iterator();
		int index =-1;		
		while(iter.hasNext()){
			String str = iter.next();
			boolean flag = compareTwoString(item,str);
			index++;
			if(!flag){
				break;
			}			
		}
		if(index == list.size()-1){
			boolean flag = compareTwoString(item,list.get(list.size()-1));
			if(flag){
				list.add(item);
			}else{
				list.add(index, item);
			}
		}else{
			list.add(index, item);		
		}		
	}
	
	public static boolean compareTwoString(String item,String str){
		char[] str1 = str.toCharArray();
		char[] item1 = item.toCharArray();
		int length = Math.min(str1.length, item1.length);
		for(int i=0;i<length;i++){
			if(str1[i]==item1[i]){
				continue;
			}
			if(str1[i]<item1[i]){
				return true;
			}else{
				return false;
			}
		}
		if(str1.length>item1.length){
			return true;
		}		
		return false;		
	}
	
}
