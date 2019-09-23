package org.zhouhy.hz41382.java.caculator.md02.common;

import java.util.List;

public class CommonUtil {
	
	private CommonUtil(){
		//empty 
	}	
	public static String presentList(List<String> strList){
		StringBuilder sb = new StringBuilder();
		for (String str : strList) {
			sb.append(str);
			sb.append(",");
		}
		return sb.toString();
	}
	
	public static String processDoublMinus(String inputStr) {
		return inputStr.replaceAll(CaculatorConstant.DOUBLESUBSTRACT, CaculatorConstant.ADD);
	}
	
	public static String spliceString(List<String> strList) {
		StringBuilder sb = new StringBuilder();
		for (String str : strList) {
			sb.append(str);
		}
		return sb.toString();
	}
}
