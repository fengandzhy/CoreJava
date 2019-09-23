package org.zhouhy.hz41382.java.unicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.zhouhy.hz41382.java.common.StringUtils;

public class UnicodeUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UnicodeUtil.class);
	
	/**
	 * translate unicode to string
	 * @author hz41382
	 * @param string
	 * @return
	 * 
	 * */
	public static String unicode2String(String unicode){
		if (StringUtils.isBlank(unicode)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int i;
		int pos = 0;
		while ((i = unicode.indexOf("\\u", pos)) != -1) {
			sb.append(unicode.substring(pos, i));
			if (i + 5 < unicode.length()) {
				pos = i + 6;
				sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));//转换关键将一个16进制的数转换成10进制
				LOGGER.info(sb.toString());
			}
		}
		sb.append(unicode.substring(pos));
		return sb.toString();
	}
	
	/**
	 * translate string to unicode
	 * @author hz41382
	 * @param string
	 * @return
	 * 
	 * */
	public static String string2Unicode(String str){
		if (StringUtils.isBlank(str)) {
			return null;
		}
		
		StringBuffer unicode = new StringBuffer();
		char[] bytes = str.toCharArray();
		for (char c : bytes){
			
			// 标准ASCII范围内的字符，直接输出char可以跟int比，比的是ascii码
			if(c >= 0 && c <= 127){
				unicode.append(c);
				continue;
			}
			
			String hexString = Integer.toHexString(c);
			unicode.append("\\u");
			if (hexString.length() < 4) {
				unicode.append("0000".substring(hexString.length(), 4));
			}			
		}
		return unicode.toString(); //一个unicode直接toString 就能转成字符串
	}
	
	public static void main(String args[]){
		char c = '9';
		System.out.println(c>9);
	}
}
