/**
 * @author NAVYA
 *
 */
package com.cg.SpringBootMVCFrs.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.SpringBootMVCFrs.dto.Flight;
import com.cg.SpringBootMVCFrs.exception.CustomGenericExeption;
import com.cg.SpringBootMVCFrs.exception.FlightExceptions;



public interface FlightService {

	//Method to 
public  Flight addFlight(Flight flight);
	//Method to view all flight available
	public List<Flight> viewAllFlight() throws FlightExceptions;
	//Method to search flight by id
	public Flight searchFlight(BigInteger flightId) throws FlightExceptions;
	//Method to modify flight by id
	public Flight modifyFlight(Flight flight) throws FlightExceptions;
	//Method to delete flight by id
	public boolean deleteFlight(BigInteger flightId) throws FlightExceptions;
	
	
	
}
