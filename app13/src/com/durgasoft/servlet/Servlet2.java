package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		urlPatterns = { "/servlet" }, 
		initParams = { 
				@WebInitParam(name = "e", value = "eeee"), 
				@WebInitParam(name = "f", value = "ffff")
		})
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		
		out.println("<h1>");
		out.println("a--->"+context.getInitParameter("a")+"<br>");
		out.println("b--->"+context.getInitParameter("b")+"<br>");
		out.println("c--->"+config.getInitParameter("c")+"<br>");
		out.println("d--->"+config.getInitParameter("d")+"<br>");
		out.println("e--->"+config.getInitParameter("e")+"<br>");
		out.println("f--->"+config.getInitParameter("f"));
		out.println("</h1>");
		
	}

}
