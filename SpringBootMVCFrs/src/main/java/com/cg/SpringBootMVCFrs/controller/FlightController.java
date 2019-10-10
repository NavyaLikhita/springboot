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
	HttpSession session;
	
	@Autowired
	FlightService flightService;
	
	
	@GetMapping(value = "/home")
	public String homePage() {
		System.out.println("in home");
		return "Home";
	}

	// Send to Add Flight Page
	@GetMapping(value = "/addFlight")
	public String getAddFlightPage(@Validated@ModelAttribute("flight") Flight flight) {
		
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return "AddFlight";
		} else {
			return "LogIn";
		}
		
	}

	// Add Flight
	@PostMapping(value = "/flightAdd")
	public ModelAndView addFlight(@Validated@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			flight.setFlightState(true);
			flightService.addFlight(flight);
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());//WHETHER VIEWALL OR 
		} else {
			return new ModelAndView("LogIn");
		}
		
	}

	// Send to View Flight Page
	@GetMapping(value = "/showFlights")
	public ModelAndView getShowFlightsPage() throws FlightExceptions {
		
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return new ModelAndView("ShowFlights", "flightList", flightService.viewAllFlight());
		} else {
			return new ModelAndView("LogIn");
		}
		
	}

	// Send to Search Flight Page
	@GetMapping(value = "/searchFlight")
	public String getSearchFlightPage() {
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return "SearchFlight";
		} else {
			return "LogIn";
		}
		
	}

	// Show searched flight
	@GetMapping(value = "/flightSearch")
	public ModelAndView getSearchFlightsResult(@Validated@RequestParam("flight_id") BigInteger flightId) throws FlightExceptions {
		
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return new ModelAndView("SearchFlight", "flight", flightService.searchFlight(flightId));
		} else {
			return new ModelAndView("LogIn");
		}
		
	}

	// Send to Modify Flight Page
	@GetMapping(value = "/modifyFlight")
	public String getModifyFlightPage(@Validated@ModelAttribute("flight") Flight flight) {
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return "ModifyFlight";
		} else {
			return "LogIn";
		}
	}

	// Show Flight Details to edit
	@GetMapping(value = "/flightEditSearch")
	public ModelAndView getEditFlightsSearchResult(@Validated@RequestParam("flight_id") BigInteger flightId,@Validated
			@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return new ModelAndView("ModifyFlight", "flight", flightService.searchFlight(flightId));
		} else {
			return new ModelAndView("LogIn");
		}
		
	}

	// Save Modifies Flight Values
	@PostMapping(value = "flightModify")
	public String modifyFlight(@Validated@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			flightService.modifyFlight(flight);
			return "AdminHome";
		} else {
			return "LogIn";
		}
		
	}

	// Send to Remove Flight Page
	@GetMapping(value = "/removeFlight")
	public String getRemoveFlightPage(@Validated@ModelAttribute("flight") Flight flight) {
		
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			return "RemoveFlight";
		} else {
			return "LogIn";
		}
		
	}

	// Show Flight Details to remove
	@GetMapping(value = "/flightRemoveSearch")
	public ModelAndView getRemoveFlightsSearchResult(@Validated@RequestParam("flight_id") BigInteger flightId,
			@ModelAttribute("flight") Flight flight) throws FlightExceptions {
		
			return new ModelAndView("RemoveFlight", "flight", flightService.searchFlight(flightId));
		
	}

	// Remove Flight
	@PostMapping(value = "/flightRemove")
	public String flightRemove(@Validated@RequestParam("flight_id") BigInteger flightId) throws FlightExceptions {
		if (session.getAttribute("userRole") != null && session.getAttribute("userRole").equals("admin")) {
			flightService.deleteFlight(flightId);
			return "AdminHome";
		} else {
			return "LogIn";
		}

	}
}
