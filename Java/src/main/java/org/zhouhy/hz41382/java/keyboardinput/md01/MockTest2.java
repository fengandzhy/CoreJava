package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.util.Scanner;

/**
* <p>className: MockTest2</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class MockTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputString = scan.nextLine();
		System.out.println(getResult(inputString));		
	}
	
	public static int getResult(String inputString){
		int result =0;
		for(int i=1;i<inputString.length();i++){
			String str2 = inputString.substring(0,i);
			String str1 = inputString.substring(i);
			String rotationStr = rotation(str1,str2);
			if(rotationStr.equals(inputString)){
				result++;
			}
		}
		return result;
	}
	
	public static String rotation(String str1,String str2){
		StringBuffer sb1 = new StringBuffer(str1);
		StringBuffer sb2 = new StringBuffer(str2);		
		sb1.append(sb2.toString());
		return sb1.toString();
	}
}
