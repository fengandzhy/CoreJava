package org.zhouhy.hz41382.java.string.md02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;


/**
* <p>className: StringCompare</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月29日
*/
public class StringCompare {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		while (true) {
            String nextLine = scan.nextLine();
            if (null==nextLine || nextLine.trim().length() == 0) {               
                break;
            }
            array.add(nextLine);
        }
		IncOrder(array);		
		Iterator<String> iter = array.iterator();
		while(iter.hasNext()){
			String item = iter.next();
			System.out.println(item);
		}		
		scan.close();
	}
	
	public static void IncOrder(ArrayList<String> array){
		Collections.sort(array,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {				
				int result = o1.compareTo(o2);				
				return result;
			}				
		});
	}
	
	public static void DecOrder(ArrayList<String> array){
		Collections.sort(array,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int result = -o1.compareTo(o2);
				return result;
			}				
		});
	}
	
	public static void IncIngoreCaseOrder(ArrayList<String> array){
		Collections.sort(array,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int result = o1.compareToIgnoreCase(o2);
				return result;
			}				
		});
	}
	
	public static void DecIngoreCaseOrder(ArrayList<String> array){
		Collections.sort(array,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int result = o1.compareToIgnoreCase(o2);
				return result;
			}				
		});
	}
}
