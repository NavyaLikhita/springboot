package com.cg.frs.SpringBootFrs.controller;
/**
 * @author NAVYA
 *
 */
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.frs.SpringBootFrs.SpringBootFrsApplication;
import com.cg.frs.SpringBootFrs.dto.Flight;
import com.cg.frs.SpringBootFrs.exception.FlightExceptions;
import com.cg.frs.SpringBootFrs.service.FlightService;

@RestController
public class FlightController {
	 private static final Logger logger = LoggerFactory.getLogger(SpringBootFrsApplication.class);
	@Autowired
	FlightService flightService;

	
	/*
	 * Author: NAVYA 
	 * Description: Adds the flight 
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */
	@PostMapping(value = "/flight/add")
	public ResponseEntity<?> addData(@ModelAttribute Flight flight) {		
		
		logger.info("Adding flight.");
		Flight flightToBeAdded = flightService.saveFlight(flight);

		if (flightToBeAdded == null) {
			logger.error("flight not found");
			return new ResponseEntity("Flight not added", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("Flight Added");
			return new ResponseEntity<Flight>(flightToBeAdded, HttpStatus.OK);
		}
	}

	
	/*
	 * Author: NAVYA 
	 * Description: Gets the list of flights and displays them.
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */
	@GetMapping(value = "/flight/view")
	public ResponseEntity<?> getAllData() throws FlightExceptions {							

		logger.info("Viewing all flights.");
		List<Flight> flightList = flightService.viewAllFlight();
		if (flightList.isEmpty()) {
			logger.error("flight not found");
			return new ResponseEntity("No Data Present", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("Flights are displayed");
			return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
		}
	}

	
	/*
	 * Author: NAVYA 
	 * Description: Searches the flight by its Id
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */
	@GetMapping(value="/flight/search")
	public ResponseEntity<?> searchData(@RequestParam BigInteger flightId) throws FlightExceptions{		
		
		logger.info("Searching flights.");
		Flight flightSearched=flightService.searchFlight(flightId);
		
		if (flightSearched == null) {
			logger.error("flight not found");
			return new ResponseEntity("Flight not present", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("Flight is displayed");
			return new ResponseEntity<Flight>(flightSearched, HttpStatus.OK);
		}
		
	}
	
	/*
	 * Author: NAVYA 
	 * Description: Modifies the flight by its id
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */

	@PutMapping(value="/flight/modify")
	public ResponseEntity<Flight> modifyData(@ModelAttribute Flight flight) throws FlightExceptions{			
		
		logger.info("Modifying flights.");
Flight flightToBeModified=flightService.modifyFlight(flight);
		
		if (flightToBeModified == null) {
			logger.error("flight not found");
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("Flight is Modified");
			return new ResponseEntity<Flight>(flightToBeModified, HttpStatus.OK);
		}
		
	}
	/*
	 * Author: NAVYA 
	 * Description: Deletes the flight by its id
	 *  Created Date: 09/10/2019 
	 *  Last Modified:
	 * -
	 */
	
	@PostMapping(value="/flight/delete")
	public boolean deleteData(@RequestParam BigInteger flightId) throws FlightExceptions{					
		
boolean flightToBeDeleted=flightService.deleteFlight(flightId);
		logger.info("Flight is Deleted");
		return flightToBeDeleted;
		
	}
	
	
	
}
