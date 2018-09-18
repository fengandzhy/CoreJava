/**
 * 设置各种运算符所对应的计算方法
 */
package com.citi.hz41382.java.caculator.md01.caculate;

/**
 * @author
 *
 */
public class CalculatorUtil {

	/**
	 * [+]运算符所对应的运算
	 * @param param1 String 操作数1
	 * @param param2 String 操作数2
	 * @return 计算结果
	 */
	public static String add(String param1, String param2) {
		
		double param1D = Double.valueOf(param1).doubleValue();
		double param2D = Double.valueOf(param2).doubleValue();
		
		return String.valueOf(param1D + param2D);
	}
	
	/**
	 * [-]运算符所对应的运算
	 * @param param1 String 操作数1
	 * @param param2 String 操作数2
	 * @return 计算结果
	 */
	public static String subtract(String param1, String param2) {
		
		double param1D = Double.valueOf(param1).doubleValue();
		double param2D = Double.valueOf(param2).doubleValue();
		
		return String.valueOf(param1D - param2D);
	}
	
	/**
	 * [*]运算符所对应的运算
	 * @param param1 String 操作数1
	 * @param param2 String 操作数2
	 * @return 计算结果
	 */
	public static String multiply(String param1, String param2) {
		
		double param1D = Double.valueOf(param1).doubleValue();
		double param2D = Double.valueOf(param2).doubleValue();
		
		return String.valueOf(param1D * param2D);
	}
	
	/**
	 * [/]运算符所对应的运算
	 * @param param1 String 操作数1
	 * @param param2 String 操作数2
	 * @return 计算结果
	 */
	public static String divide(String param1, String param2) {
		
		double param1D = Double.valueOf(param1).doubleValue();
		double param2D = Double.valueOf(param2).doubleValue();
		
		return String.valueOf(param1D / param2D);
	}
	
	/**
	 * [%]运算符所对应的运算
	 * @param param1 String 操作数1
	 * @param param2 String 操作数2
	 * @return 计算结果
	 */
	public static String mod(String param1, String param2) {
		
		double param1D = Double.valueOf(param1).doubleValue();
		double param2D = Double.valueOf(param2).doubleValue();
		
		return String.valueOf(param1D % param2D);
	}
	
	/**
	 * [^](幂)运算符所对应的运算
	 * @param param1 String 操作数1
	 * @param param2 String 操作数2
	 * @return 计算结果
	 */
	public static String pow(String param1, String param2) {
		
		double param1D = Double.valueOf(param1).doubleValue();
		double param2D = Double.valueOf(param2).doubleValue();
		
		return String.valueOf(Math.pow(param1D, param2D));
	}
	
	/**
	 * [sin]运算符所对应的运算
	 * @param param String 操作数
	 * @return 计算结果
	 */
	public static String sin(String param) {
		
		double paramD = Double.valueOf(param).doubleValue();
		
		return String.valueOf(Math.sin(paramD));
	}
	
	/**
	 * [cos]运算符所对应的运算
	 * @param param String 操作数
	 * @return 计算结果
	 */
	public static String cos(String param) {
		
		double paramD = Double.valueOf(param).doubleValue();
		
		return String.valueOf(Math.cos(paramD));
	}
	
	/**
	 * [tan]运算符所对应的运算
	 * @param param String 操作数
	 * @return 计算结果
	 */
	public static String tan(String param) {
		
		double paramD = Double.valueOf(param).doubleValue();
		
		return String.valueOf(Math.tan(paramD));
	}
	
	/**
	 * [ctg]运算符所对应的运算
	 * @param param String 操作数
	 * @return 计算结果
	 */
	public static String ctg(String param) {
		
		double paramD = Double.valueOf(param).doubleValue();
		
		return String.valueOf(1d / Math.tan(paramD));
	}
	
	/**
	 * [lg]运算符所对应的运算
	 * @param param String 操作数
	 * @return 计算结果
	 */
	public static String lg(String param) {
		
		double paramD = Double.valueOf(param).doubleValue();
		
		return String.valueOf(Math.log10(paramD));
	}
	
	/**
	 * [ln]运算符所对应的运算
	 * @param param String 操作数
	 * @return 计算结果
	 */
	public static String ln(String param) {
		
		double paramD = Double.valueOf(param).doubleValue();
		
		return String.valueOf(Math.log(paramD));
	}
}
