package org.zhouhy.hz41382.java.exception.md02;

public class CustomerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -245948538378010385L; 
	
	public CustomerException() {
		super();
	}
	
	public CustomerException(String message) {
		super(message);
	}
 
	public CustomerException(String retCd, String msgDes) {
		super(retCd+":"+msgDes);
	}
}
