package com.durgasoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("servlet Loading");
	}
	public TestServlet()
	{
		System.out.println("Servlet Instantiation");
	}
	public void init() {
		System.out.println("Servlet initialization");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Processing");
	}
	public void destroy() {
		System.out.println("Servlet Deinstantiation");
	}
}
