package com.wipro.service;

import java.util.List;
import java.util.stream.Collectors;

import com.wipro.model.Flight;
import com.wipro.service.impl.MySqlServiceImpl;

public class FlightSearchService {
	private static MySqlService mySqlService;

	static {
		mySqlService = new MySqlServiceImpl();
	}

	public List<Flight> searchFlights(String departureAirport, String destinationAirport) {
		return mySqlService.findAllFlights()
				.stream()
				.filter(flight -> flight.getDepartureAirport()
						.equals(departureAirport)
						&& flight.getDestinationAirport()
								.equals(destinationAirport)
						&& flight.checkAvailability())
				.collect(Collectors.toList());
	}
}
