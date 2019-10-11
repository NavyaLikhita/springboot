/**
 * 
 */
package com.cg.SpringBootMVCFrs.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
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

	// Send to Add Flight Page
	@GetMapping(value = "/addFlight")
	public String getAddFlightPage(@ModelAttribute("flight") Flight flight) {
		
		
			return "AddFlight";
		
		
	}

	// Add Flight
	@PostMapping(value = "/flightAdd")
	public ModelAndView addFlight(@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
			flight.setFlightState(true);
			flightService.addFlight(flight);
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());//WHETHER VIEWALL OR 
		
		
	}

	// Send to View Flight Page
	@GetMapping(value = "/showFlights")
	public ModelAndView getShowFlightsPage() throws FlightExceptions {
		
		
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());
		
		
	}

	// Send to Search Flight Page
	@GetMapping(value = "/searchFlight")
	public String getSearchFlightPage() {
		
			return "SearchFlight";
		
		
	}

	// Show searched flight
	@GetMapping(value = "/flightSearch")
	public ModelAndView getSearchFlightsResult(@RequestParam("flight_id") BigInteger flightId) throws FlightExceptions {
		
		
			return new ModelAndView("SearchFlight", "flight", flightService.searchFlight(flightId));
		
		
	}

	// Send to Modify Flight Page
	@GetMapping(value = "/modifyFlight")
	public String getModifyFlightPage(@ModelAttribute("flight") Flight flight) {
		
			return "ModifyFlight";
		
	}

	// Show Flight Details to edit
	@GetMapping(value = "/flightEditSearch")
	public ModelAndView getEditFlightsSearchResult(@RequestParam("flight_id") BigInteger flightId,
			@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
		
			return new ModelAndView("ModifyFlight", "flight", flightService.searchFlight(flightId));
		
	}

	// Save Modifies Flight Values
	@PostMapping(value = "/flightModify")
	public String modifyFlight(@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
			flightService.modifyFlight(flight);
			return "AdminHome";
		
	}

	// Send to Remove Flight Page
	@GetMapping(value = "/removeFlight")
	public String getRemoveFlightPage(@ModelAttribute("flight") Flight flight) {
		
		
			return "RemoveFlight";
		
		
	}

	// Show Flight Details to remove
	@GetMapping(value = "/flightRemoveSearch")
	public ModelAndView getRemoveFlightsSearchResult(@RequestParam("flight_id") BigInteger flightId,
			@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
			return new ModelAndView("RemoveFlight", "flight", flightService.searchFlight(flightId));
		
	}

	// Remove Flight
	@PostMapping(value = "/flightRemove")
	public String flightRemove(@RequestParam("flight_id") BigInteger flightId) throws FlightExceptions {
		
			flightService.deleteFlight(flightId);
			return "AdminHome";
		

	}
}
