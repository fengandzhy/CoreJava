package org.zhouhy.hz41382.java.keyboardinput.md01;
/**
* <p>className: Test_2</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class Test_2 {

	public static void main(String[] args) {
		String string = rotation("abc","def");
//		System.out.println(string);
		getResult("ababab");
	}
	
	public static String rotation(String str1,String str2){
		StringBuffer sb1 = new StringBuffer(str1);
		StringBuffer sb2 = new StringBuffer(str2);		
		sb1.append(sb2.reverse().toString());
		return sb1.toString();
	}
	
	public static int getResult(String inputString){
		int result =0;
		for(int i=1;i<inputString.length();i++){
			String str2 = inputString.substring(0,i);
			String str1 = inputString.substring(i);
			System.out.println(str2);
			System.out.println(str1);
		}
		return result;
	}

}
