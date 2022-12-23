package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		name = "testServlet", 
		urlPatterns = { 
				"/test1", 
				"/test2", 
				"/test3"
		},loadOnStartup =1)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("servlet loading");
	}
	public TestServlet() {
		System.out.println("Servlet instantiation");
	}
	public void init() {
		System.out.println("Servlet initialization");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>This is from TestServlet with Annotations</h1>");
		System.out.println("TestServlet Request Processing ");
	}
	public void destroy() {
		System.out.println("Servlet Deinstantiation");
	}
}
