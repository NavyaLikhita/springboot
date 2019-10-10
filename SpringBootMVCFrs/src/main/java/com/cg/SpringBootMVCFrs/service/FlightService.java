/**
 * 
 */
package com.cg.SpringBootMVCFrs.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.SpringBootMVCFrs.dto.Flight;
import com.cg.SpringBootMVCFrs.exception.FlightExceptions;



public interface FlightService {

	
public  Flight addFlight(Flight flight);
	
	public List<Flight> viewAllFlight() throws FlightExceptions;
	
	public Flight searchFlight(BigInteger flightId) throws FlightExceptions;
	
	public Flight modifyFlight(Flight flight) throws FlightExceptions;
	
	public boolean deleteFlight(BigInteger flightId) throws FlightExceptions;
	
	
	
}
