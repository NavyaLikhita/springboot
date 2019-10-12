/**
 * 
 */
package com.cg.SpringBootMVCFrs.service;

import java.math.BigInteger;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.SpringBootMVCFrs.SpringBootMvcFrsApplication;
import com.cg.SpringBootMVCFrs.dao.FlightDao;
import com.cg.SpringBootMVCFrs.dto.Flight;
import com.cg.SpringBootMVCFrs.exception.CustomGenericExeption;
import com.cg.SpringBootMVCFrs.exception.FlightExceptions;

/**
 * @author NAVYA
 *
 */

@Service("flightService")
@Transactional
public class FlightServiceImpl implements FlightService {

	// private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);
	
	@Autowired
	FlightDao flightDao;
	
	
	@Override
	//Saves the Flight and sets the states to true
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		
		flight.setFlightState(true);
		
		return flightDao.save(flight);
	}

	@Override
	//Displays all the flights available
	public List<Flight> viewAllFlight() throws FlightExceptions {
		// TODO Auto-generated method stub
		List<Flight> flightList=flightDao.findAll();
		if(flightList.isEmpty()) {
			
			throw new FlightExceptions("NO FLIGHT IS AVAILABLE");
		}
		
		return flightList;
	}

	@Override
	//Searches the available flight through entered flight id
	public Flight searchFlight(BigInteger flightId) throws FlightExceptions {
		// TODO Auto-generated method stub
		Flight flightFound=flightDao.findByFlightId(flightId);
		
		if(flightFound==null || flightFound.getFlightState()==false) {
			
			throw new FlightExceptions("NO FLIGHT HAVING THIS ID IS AVAILABLE");
			
		}
		return flightFound;
	}

	@Override
	//Modifies the flight by flight id
	public Flight modifyFlight(Flight flight) throws FlightExceptions {
		// TODO Auto-generated method stub
		
		Flight flightToBeModified=flightDao.findByFlightId(flight.getFlightId());
          if(flightToBeModified==null) {
			
			throw new FlightExceptions("FLIGHT DOESN'T EXISTS TO MODIFY");
			
		}else {
		flightToBeModified.setCarrierName(flight.getCarrierName());
		flightToBeModified.setFlightModel(flight.getFlightModel());
		flightToBeModified.setSeatCapacity(flight.getSeatCapacity());
		flightToBeModified.setFlightState(true);
		}
		return flightDao.save(flightToBeModified);
	}

	@Override
	//Deletes the flight by setting state to false
	public boolean deleteFlight(BigInteger flightId) throws FlightExceptions {
		// TODO Auto-generated method stub
		Flight removedFlight=flightDao.findByFlightId(flightId);
		 if(removedFlight==null) {
				
				throw new FlightExceptions("FLIGHT DOESN'T EXISTS TO DELETE");
				
			}
		removedFlight.setFlightState(false);
		
		 flightDao.save(removedFlight);
		 return true;
	}

}
