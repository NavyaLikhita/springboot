/**
 * 
 */
package com.cg.SpringBootMVCFrs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


import com.cg.SpringBootMVCFrs.SpringBootMvcFrsApplication;

import com.cg.SpringBootMVCFrs.exception.FlightExceptions;

/**
 * @author NAVYA
 *
 */

@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootMvcFrsApplication.class);
	
	@ExceptionHandler(FlightExceptions.class)
	public ModelAndView handleCustomException(FlightExceptions ex) {

		ModelAndView model = new ModelAndView("ErrorPage");
		
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	
	
	
}
