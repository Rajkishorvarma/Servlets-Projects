package com.durgasoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("HelloServlet Loading");
	}
	public HelloServlet() {
		System.out.println("HelloServlet Instantiation");
	}
	public void init() {
		System.out.println("HelloServlet Initialization");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet Request Processing ");
	}
	public void destroy() {
		System.out.println("HelloServlet Deinstantiation");
	}

}
