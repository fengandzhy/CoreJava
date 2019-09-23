package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
* <p>className: Test1</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class Main {

	public static void main(String[] args) {
		int firstNumber =0; 
		int secondNumber = 0;
		Scanner arr=new Scanner(System.in);		
		firstNumber = arr.nextInt();				
		secondNumber = arr.nextInt();	
		List<Integer> list = processNumber(firstNumber,secondNumber);
		if(list.size()==0){
			System.out.println(0);
			return;
		}
		List<Integer> primelist = getPrimeNumberList(list);
		if(primelist.size()==0){
			System.out.println(0);
			return;
		}
		List<Integer> list1 = processNumber(2,primelist.get(primelist.size()-1));
		List<Integer> primelist1 = getPrimeNumberList(list1);
		System.out.println(primelist);
		System.out.println(primelist1);
		int result = getFinalResult(primelist,primelist1);
		System.out.println(result);
		arr.close();
	}
	
	public static List<Integer> processNumber(int first,int second){
		List<Integer> list = new ArrayList<>();
		if(first == second){
			return list;
		}
		if(first < second ){
			for(int i=first;i<=second;i++){
				list.add(i);
			}
			return list;
		}
		
		for(int i=second;i<=first;i++){
			list.add(i);
		}		
		return list;
	}
	
	public static List<Integer> getPrimeNumberList(List<Integer> list){
		List<Integer> primelist = new ArrayList<>();
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			int number = iterator.next();
			if(isPrime(number)){
				primelist.add(number);
			}
		}		
		return primelist;
	}
	
	public static boolean isPrime(int number){
		if(number < 2){
			return false;
		}
		if(number ==2){
			return true;
		}
		for(int i=2;i<number;i++){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}
	
	
	public static int getFinalResult(List<Integer> primelist,List<Integer> primelist1){
		int result =0;
		for(int i=0;i<primelist.size();i++){
			int number = primelist.get(i);
			if(isResult(number,primelist1)){
				result++;
			}
		}
		return result;
	}
	
	public static boolean isResult(int number,List<Integer> primelist){		
		for(int i=1;i<primelist.size();i++){
			if(number==primelist.get(i)+primelist.get(i-1)+1){
				System.out.println(number+","+primelist.get(i)+","+primelist.get(i-1));
				return true;
			}
		}
		return false;
	}

}
