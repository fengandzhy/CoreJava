package com.citi.hz41382.java.caculator.md02.exceptions;

public class ExpressionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978066955972434072L;
	private String errCode;
	private String errMsg;
	
	public ExpressionException() {
		super();
	}
	
	public ExpressionException(String message) {
		super(message);
	}
 
	public ExpressionException(String retCd, String msgDes) {
		super(retCd+":"+msgDes);
		this.errCode = retCd;
		this.errMsg = msgDes;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
