package org.zhouhy.hz41382.java.keyboardinput.md01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* <p>className: Test_1</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月12日
*/
public class Test_1 {
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
		System.out.println(array);
    }
}
