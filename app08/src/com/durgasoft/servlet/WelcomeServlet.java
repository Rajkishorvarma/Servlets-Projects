package com.durgasoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("WelcomeServlet Loading");
	}
	public WelcomeServlet() {
		System.out.println("WelcomeServlet Instantiation");
	}
	public void init() {
		System.out.println("WelcomeServlet Initialization");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WelcomeServlet Request Processing ");
	}
	public void destroy() {
		System.out.println("WelcomeServlet Deinstantiation");
	}

}
