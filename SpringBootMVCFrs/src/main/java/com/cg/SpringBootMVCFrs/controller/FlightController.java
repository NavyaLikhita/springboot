/**
 * 
 */
package com.cg.SpringBootMVCFrs.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.SpringBootMVCFrs.dto.Flight;
import com.cg.SpringBootMVCFrs.exception.FlightExceptions;
import com.cg.SpringBootMVCFrs.service.FlightService;

/**
 * @author Navya
 *
 */
@ComponentScan
@Controller

public class FlightController {

	
	
	@Autowired
	FlightService flightService;
	
	
	@GetMapping(value = "/home")
	public String homePage() {
		System.out.println("in home");
		return "Home";
	}

	// Will Open Page To Add Flight 
	@GetMapping(value = "/add")
	public String getAddFlightPage(@ModelAttribute("flight") Flight flight) {
		
		
			return "AddFlight";
		
		
	}

	// Will Add The New Flight Details And Display Them
	@PostMapping(value = "/added")
	public ModelAndView addFlight(@Valid@ModelAttribute("flight") Flight flight, BindingResult result) throws FlightExceptions {
		if(result.hasErrors()) {
			
			return new ModelAndView("AddFlight","flight",flight);
			
		}
			flight.setFlightState(true);
			flightService.addFlight(flight);
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());
		
		
	}

	// Display The Available Flights
	@GetMapping(value = "/show")
	public ModelAndView getShowFlightsPage() throws FlightExceptions {
		
		
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());
		
		
	}

	// Will Open Page To Search Flight 
	@GetMapping(value = "/search")
	public String getSearchFlightPage() {
		
			return "SearchFlight";
		
		
	}

	// Shows The Searched Flight Details
	@GetMapping(value = "/found")
	public ModelAndView getSearchFlightsResult(@RequestParam("flight_id") BigInteger flightId) throws FlightExceptions {
		
		
			return new ModelAndView("SearchFlight", "flight", flightService.searchFlight(flightId));
		
		
	}

	// Will Open Page To Modify Flight 
	@GetMapping(value = "/modify")
	public String getModifyFlightPage(@ModelAttribute("flight") Flight flight) {
		
			return "ModifyFlight";
		
	}

	// Shows The Flight To Be Modified
	@GetMapping(value = "/searched")
	public ModelAndView getEditFlightsSearchResult(@RequestParam("flight_id") BigInteger flightId,
			@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
		
			return new ModelAndView("ModifyFlight", "flight", flightService.searchFlight(flightId));
		
	}

	// Modifies The Flight And Returns To--
	@PostMapping(value = "/modified")
	public ModelAndView modifyFlight(@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
			flightService.modifyFlight(flight);
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());
		
	}

	// Will Open Page To Modify Flight 
	@GetMapping(value = "/remove")
	public String getRemoveFlightPage(@ModelAttribute("flight") Flight flight) {
		
		
			return "RemoveFlight";
		
		
	}

	// Shows The Flight To Be Removed
	@GetMapping(value = "/removesearch")
	public ModelAndView getRemoveFlightsSearchResult(@RequestParam("flight_id") BigInteger flightId,
			@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
			return new ModelAndView("RemoveFlight", "flight", flightService.searchFlight(flightId));
		
	}

	//Removes The Flight And Returns To--
	@PostMapping(value = "/removed")
	public ModelAndView flightRemove(@RequestParam("flight_id") BigInteger flightId) throws FlightExceptions {
		
			flightService.deleteFlight(flightId);
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());
		

	}
}
