package org.zhouhy.hz41382.java.inherit.md01;
/**
* <p>className: a</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月24日
*/
public class a {

	public static void main(String[] args) {
		boolean b = false;
		System.out.println((b = true) ? "true" : "false");
		int c = 0;
		System.out.println((0 == c++) ? "true" : "false"); 
		Double d = null;		
		System.out.println((d instanceof Double) ? "true" : "false"); 
		String e = "1";
		System.out.println(("1" != e) ? "true" : "false");
		int a = 0;		
		System.out.println((a != 0) ? "true" : "false");
	}

}
