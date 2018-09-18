/**
 * 定义所有常量
 */
package com.citi.hz41382.java.caculator.md01.util;

import java.util.HashMap;
import java.util.Map;

import com.citi.hz41382.java.caculator.md01.operator.Yunsuanfu;

/**
 * @author
 *
 */
public class Constant {

	/** 运算符集合 */
	public static final Map<String, Yunsuanfu> YUN_SUAN_FU_SET = getInitMap();
	
	/** 运算符的正则表达式集合 */
	public static final HashMap<String, String> YSF_FROM_REGEX = getYsfFromRegexYsf();
	
	/** 正则表达式的运算符集合 */
	public static final HashMap<String, String> REGEX_FROM_YSF = getRegexYsfFromYsf();
	
	/** 运算式所对应的计算方式的集合 */
	public static final HashMap<String, String> CALC_NAME_FROM_YSF = getCalcNameFromYsf();
	
	/** 运算式所对应的优先级标志集合 */
	public static final HashMap<String, String> PRIORITY_FROM_YSF = getYsfPriorityFromYsf();
	
	/** 所有正则表达式 */
	public static final String[] ALL_REGEX_YSF = getAllRegexYsf();
	
	/**括号的优先级标志：1*/
	public static final String YSF_PRIORITY_BRACKET = "1";
	
	/**单目运算符的优先级标志：2*/
	public static final String YSF_PRIORITY_SINGLE = "2";
	
	/**双目运算符的优先级标志：3*/
	public static final String YSF_PRIORITY_DOUBLE = "3";
	
	/**运算结果的精度*/
	public static final int SCALE = 6;
	
	/**左括号*/
	public static final String LEFT_BRACKET = getYsfRegexMap()[0][0];
	
	/**右括号*/
	public static final String RIGHT_BRACKET = getYsfRegexMap()[1][0];
	
	/**
	 * 初期化运算符常量
	 * @return 运算符常量
	 */
	private static HashMap<String, Yunsuanfu> getInitMap() {
		HashMap<String, Yunsuanfu> yunsuanfuMap = new HashMap<String, Yunsuanfu>();
		
		for (String[] tmpA : getYsfRegexMap()) {
			yunsuanfuMap.put(tmpA[0], new Yunsuanfu(tmpA[0], tmpA[2], tmpA[3]));
		}
		
		return yunsuanfuMap;
	}
	
	/**
	 * 由正则表达式取得对应的字符
	 * @return 正则表达式取得对应的字符
	 */
	private static HashMap<String, String> getYsfFromRegexYsf() {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		for (String[] tmpA : getYsfRegexMap()) {
			resultMap.put(tmpA[1], tmpA[0]);
		}
		return resultMap;
	}

	/**
	 * 由字符取得运算式所对应的计算方式的集合
	 * @return 运算式所对应的计算方式的集合
	 */
	private static HashMap<String, String> getCalcNameFromYsf() {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		for (String[] tmpA : getYsfRegexMap()) {
			if (!"".equals(tmpA[4])) {
				resultMap.put(tmpA[0], tmpA[4]);
			}
		}
		return resultMap;
	}
	
	/**
	 * 由字符取得运算式所对应的优先级标志集合
	 * @return 运算式所对应的优先级标志集合
	 */
	private static HashMap<String, String> getYsfPriorityFromYsf() {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		for (String[] tmpA : getYsfRegexMap()) {
			resultMap.put(tmpA[0], tmpA[3]);
		}
		return resultMap;
	}
	
	/**
	 * 由字符取得字符对应的正则表达式
	 * @return 字符对应的正则表达式
	 */
	private static HashMap<String, String> getRegexYsfFromYsf() {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		for (String[] tmpA : getYsfRegexMap()) {
			resultMap.put(tmpA[0], tmpA[1]);
		}
		return resultMap;
	}
	
	/**
	 * 取得所有字符的正则表达式
	 * 字符的顺序按优先级的高低顺次排列
	 * @return 所有字符的正则表达式
	 */
	private static String[] getAllRegexYsf() {
		String[][] ysfRegexMap = getYsfRegexMap();
		String[] regexResult = new String[ysfRegexMap.length];
		for (int i = 0; i < regexResult.length; i++) {
			regexResult[i] = ysfRegexMap[i][1];
		}
		
		return regexResult;
	}
	
	/**
	 * 运算符与对应的正则表达式表示
	 * @return 运算符与对应的正则表达式的对应关系
	 */
	private static String[][] getYsfRegexMap() {
		
		/**
		 * {字符表示，字符正则表达式表示形式，优先级，优先级标志位, 关联计算方法名}
		 * 其中：
		 *   优先级--越小优先级越高
		 *   优先级标志位：
		 *         1：括号
		 *         2：单目运算符
		 *         3：双目运算符
		 *   关联计算方法：qi.yunsuan.jisuan.CalculatorUtil中的对应方法
		 */ 
		return new String[][] {
				{ "(", "\\(", "01", YSF_PRIORITY_BRACKET, "" },
				{ ")", "\\)", "01", YSF_PRIORITY_BRACKET, "" },
				{ "^", "\\^", "11", YSF_PRIORITY_DOUBLE, "pow" },
				{ "*", "\\*", "12", YSF_PRIORITY_DOUBLE, "multiply" },
				{ "/", "\\/", "12", YSF_PRIORITY_DOUBLE, "divide" },
				{ "%", "\\%", "12", YSF_PRIORITY_DOUBLE, "mod" },
				{ "+", "\\+", "13", YSF_PRIORITY_DOUBLE, "add" },
				{ "-", "\\-", "13", YSF_PRIORITY_DOUBLE, "subtract" },
				{ "sin", "(sin)", "21", YSF_PRIORITY_SINGLE, "sin" },
				{ "cos", "(cos)", "21", YSF_PRIORITY_SINGLE, "cos" },
				{ "tan", "(tan)", "21", YSF_PRIORITY_SINGLE, "tan" },
				{ "ctg", "(ctg)", "21", YSF_PRIORITY_SINGLE, "ctg" },
				{ "lg", "(lg)", "21", YSF_PRIORITY_SINGLE, "lg" },
				{ "ln", "(ln)", "21", YSF_PRIORITY_SINGLE, "ln" } };
	}
}