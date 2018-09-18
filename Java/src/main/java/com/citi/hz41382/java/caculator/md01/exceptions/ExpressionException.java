package com.citi.hz41382.java.caculator.md01.exceptions;

public class ExpressionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978066955972434072L;
	
	public ExpressionException() {
		super();
	}
	
	public ExpressionException(String message) {
		super(message);
	}
 
	public ExpressionException(String retCd, String msgDes) {
		super(retCd+":"+msgDes);
	}

}
