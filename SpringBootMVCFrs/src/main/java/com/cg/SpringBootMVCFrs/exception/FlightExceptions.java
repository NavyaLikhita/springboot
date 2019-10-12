/**
 * 
 */
package com.cg.SpringBootMVCFrs.exception;


import com.cg.SpringBootMVCFrs.SpringBootMvcFrsApplication;

/**
 * @author NAVYA
 *
 */
public class FlightExceptions extends Exception{

	// private static final Logger logger = LoggerFactory.getLogger(FlightExceptions.class);
	
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

	public FlightExceptions( String errMsg) {
		
		this.errMsg = errMsg;
	}
	
	
	
	
}
