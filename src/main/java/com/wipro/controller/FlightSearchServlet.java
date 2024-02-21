package com.wipro.controller;

import java.io.IOException;
import java.util.List;

import com.wipro.model.Flight;
import com.wipro.service.FlightSearchService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FlightSearch")
public class FlightSearchServlet extends HttpServlet {
	private static FlightSearchService flightSearchService;

	@Override
	public void init() throws ServletException {
		super.init();
		flightSearchService = new FlightSearchService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		List<Flight> flights = flightSearchService.searchFlights(from, to);
		req.setAttribute("flights", flights);
		req.getRequestDispatcher("search_list.jsp")
				.forward(req, resp);
	}

}
