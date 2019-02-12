package com.citi.hz41382.java.model.common;
/**
* <p>className: CommonUtil</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class CommonUtil {
	private CommonUtil(){
		
	}
	
	public static String transferBoolean(boolean flag){
		if(!flag)
			return "not ";
		return "";
	}
}
