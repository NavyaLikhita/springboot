/**
 * 
 */
package com.cg.SpringBootMVCFrs.exception;


import com.cg.SpringBootMVCFrs.SpringBootMvcFrsApplication;

/**
 * @author NAVYA
 *
 */
public class CustomGenericExeption extends RuntimeException {

	// private static final Logger logger = LoggerFactory.getLogger(CustomGenericExeption.class);
	/**
	 * 
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
