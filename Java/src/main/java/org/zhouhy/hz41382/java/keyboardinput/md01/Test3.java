package org.zhouhy.hz41382.java.keyboardinput.md01;


import java.util.Scanner;

/**
* <p>className: Test1</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class Test3 {
	public static void main(String[] args) {
		int arrayLength =0;	
		Scanner arr=new Scanner(System.in);
		arrayLength = arr.nextInt();
		int[] inputArray = new int[arrayLength];
		for(int i=0;i<arrayLength;i++){
			inputArray[i] = arr.nextInt();
		}
		int[] outArray = new int[arrayLength];
		for(int i=0;i<arrayLength;i++){
			outArray[arrayLength-1-i]=inputArray[i];
		}
		for(int i=0;i<arrayLength;i++){
			System.out.print(outArray[i]+" ");
		}
		arr.close();
	}
}
