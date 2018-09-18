package Java.ThinkinginJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class InputTest {

	@Test
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = buf.readLine();
		process(str);
	}
	
	public static void process(String str){
		String[] strArray=str.split(",");
		double sum = addNumber(strArray);
		System.out.println(sum);
	}
	
	public static double addNumber(String[] strArray){
		double sum = 0;
		for(String a1 : strArray){
			Double b=Double.parseDouble(a1);
			sum = sum +b;
		}
		return sum;
	}

}
