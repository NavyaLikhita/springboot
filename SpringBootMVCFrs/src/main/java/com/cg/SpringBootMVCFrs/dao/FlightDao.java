/**
 * 
 */
package com.cg.SpringBootMVCFrs.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.cg.SpringBootMVCFrs.dto.Flight;

/**
 * @author NAVYA
 *
 */

public interface FlightDao extends JpaRepository<Flight, BigInteger> {


	/*
	 * Author: NAVYA 
	 * Description: Repository of flight for adding,view and find
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */
	
	//Saves flight
	public Flight save(Flight flight);
	//shows all flight where state is true
	@Query("FROM Flight WHERE flightState=true")
	public List<Flight> viewAll();
	//Search flight by id
	public Flight findByFlightId(BigInteger flightId);
	
	
	
}
