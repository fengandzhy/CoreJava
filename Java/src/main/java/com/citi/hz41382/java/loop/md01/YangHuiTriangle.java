package com.citi.hz41382.java.loop.md01;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YangHuiTriangle {

	private static final Logger LOGGER = LoggerFactory.getLogger(YangHuiTriangle.class);
	private YangHuiTriangle(){}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LOGGER.info("请输入杨辉三角的行数：");
		int layer = sc.nextInt();
		outPutYangHuiTriangle(layer);
		sc.close();
	}
	
	/**
	 * Yanghui Triangle
	 * @author hz41382
	 * @param int the layer of YangHui Triangle
	 * @return
	 * 
	 * */
	public static void outPutYangHuiTriangle(int layer){
		int[][] recorder = new int[layer][layer];
		for(int i=0;i<layer;i++){
			for(int j=0;j<i+1;j++){
				if(isFirst(j) || isLast(j,i+1)){
					recorder[i][j] =1;
					printNumber(recorder[i][j],i,j);
					continue;
				}
				recorder[i][j] = recorder[i-1][j]+recorder[i-1][j-1];
				printNumber(recorder[i][j],i,j);
			}
			System.out.println("\n");
		}		
	}
	
	private static boolean isFirst(int j){
		if(j == 0){
			return true;
		}
		return false;
	}
	
	private static boolean isLast(int j, int layer){
		if(j == layer-1){
			return true;
		}
		return false;
	}
	
	private static void printNumber(int recorder,int i, int j){			
		System.out.print(String.valueOf(recorder));	
		if(i != j){
			System.out.print(",");
		}		
	}
}
