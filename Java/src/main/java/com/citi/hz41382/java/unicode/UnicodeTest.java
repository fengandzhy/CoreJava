package com.citi.hz41382.java.unicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnicodeTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UnicodeTest.class);
	
	public static void main(String args[]){
		String str = "【";
		String unicode = UnicodeUtil.string2Unicode(str);
		LOGGER.info(unicode);
		
		String unicode1 = "\\u3010\\u9009\\u62E9\\u6392\\u5E8F\\u7B97\\u6CD5\\u3011";		
		String str1 = UnicodeUtil.unicode2String(unicode1);
		LOGGER.info(str1);
	}
	
	
}
