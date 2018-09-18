/**
 * 定义所有的运算符以及运算符的说明：单目还是双目
 * 所有的信息在创建之后是不能被修改的
 */
package com.citi.hz41382.java.caculator.md01.operator;

/**
 * @author
 *
 */
public final class Yunsuanfu {

	/** 符号表示 */
	private String symbol;
	
	/** 优先级 */
	private String priority;
	
	/** 优先级标志 */
	private String priorityFlg;
	
	/** 
	 * 构造方法 
	 * 
	 * @param symbol 运算符
	 * @param priority 优先级
	 * @param priorityFlg 优先级标志位
	 */
	public Yunsuanfu(String symbol, String priority, String priorityFlg) {
		this.symbol = symbol;
		this.priority = priority;
		this.priorityFlg = priorityFlg;
	}

	/**
	 * @return priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @return priorityFlg
	 */
	public String getPriorityFlg() {
		return priorityFlg;
	}

	/**
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}
}
