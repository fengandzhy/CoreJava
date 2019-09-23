package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.util.Scanner;

/**
* <p>className: Test</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class Test2 {

	public static void main(String[] args) {
		int[] firstNumber =new int[3]; 
		int[] secondNumber = new int[3];
		Scanner arr=new Scanner(System.in);
		for(int i=0;i<firstNumber.length;i++){
			firstNumber[i] = arr.nextInt();	
		}		
		for(int i=0;i<secondNumber.length;i++){
			firstNumber[i] = arr.nextInt();	
		}
		
		double xDistance = firstNumber[0]-secondNumber[0];
		double yDistance = firstNumber[1]-secondNumber[1];
		
		if((firstNumber[0]-secondNumber[0]==0)&&(firstNumber[1]-secondNumber[1]==0)){
			System.out.println("YES");
		}
		
		double distance = Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2));
		
		if(distance>firstNumber[2] &&distance > secondNumber[2]){
			if(distance<firstNumber[2]+secondNumber[2]){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}else{
			
		}
		
		
		arr.close();
	}

}
