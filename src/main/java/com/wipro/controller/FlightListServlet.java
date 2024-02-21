package com.wipro.controller;

import java.io.IOException;

import com.wipro.service.MySqlService;
import com.wipro.service.impl.MySqlServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FlightList")
public class FlightListServlet extends HttpServlet {
	private static MySqlService mySqlService;

	@Override
	public void init() throws ServletException {
		super.init();
		mySqlService = new MySqlServiceImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("flights", mySqlService.findAllFlights());
		req.getRequestDispatcher("flight_list.jsp")
				.forward(req, resp);
	}

}
