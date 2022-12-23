package com.durgasoft.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/airtel")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3 align='center' > To Get Service From Airtel, Click on <br>");
		out.println("<a href='http://localhost:8787/app23/welcome.html'>CC@Vodafone.com</a></h3>");
		out.println("</body></html>"); */
		/*
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("location", "http://localhost:8787/app23/welcome.html"); */
		
		response.sendRedirect("http://localhost:8787/app23/welcome.html");
	}

}
