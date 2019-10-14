/**
 * 
 */
package com.cg.SpringBootMVCFrs.exception;




/**
 * @author NAVYA
 *
 */
public class CustomGenericExeption extends RuntimeException {


	/*
	 * Author: NAVYA 
	 * Description: Exception class
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	private String errMsg;

	

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CustomGenericExeption( String errMsg) {
		
		this.errMsg = errMsg;
	}
	
	
	
	
	
}
