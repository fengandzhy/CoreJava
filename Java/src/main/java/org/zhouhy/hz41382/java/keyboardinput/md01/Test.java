package org.zhouhy.hz41382.java.keyboardinput.md01;
/**
* <p>className: Test</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class Test {

	public static void main(String[] args) {
		String str= "lpk";
		String item = "asdf";
		System.out.println(compareTwoString(item,str));
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
