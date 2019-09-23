package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.io.*;
import java.util.ArrayList;




/**
* <p>className: MockTest3</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class MockTest3 {

	public static void main(String[] args) throws IOException {
		ArrayList<String> array = new ArrayList<String>();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String nextLine = buf.readLine();
            if (null==nextLine || nextLine.trim().length() == 0) {               
                break;
            }
            array.add(nextLine);
		}
		int value = Integer.parseInt(array.get(0));
		for(int i=0;i<value;i++){
			System.out.println("NO");
		}
	}
}
