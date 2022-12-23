package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/context" }, 
		initParams = { 
				@WebInitParam(name = "driverClass", value = "oracle.jdbc.OracleDriver"), 
				@WebInitParam(name = "driverURL", value = "jdbc:oracle:thin:@localhost:1521:xe"), 
				@WebInitParam(name = "db_username", value = "system"), 
				@WebInitParam(name = "db_pwd", value = "rajkishor")
		})
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context =  getServletContext();
		String lname = context.getServletContextName();
		String driverClass = context.getInitParameter("driverClass");
		String driverURL = context.getInitParameter("driverURL");
		String db_username = context.getInitParameter("db_username");
		String db_pwd = context.getInitParameter("db_pwd");
		Enumeration<String> e1 = context.getInitParameterNames();
		String paramNames = "";
		while(e1.hasMoreElements()) {
			paramNames = paramNames + e1.nextElement() +"<b>";
		}
		context.setAttribute("a", "AAAA");
		context.setAttribute("b", "BBBB");
		context.setAttribute("c", "CCCC");
		context.setAttribute("d", "DDDD");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th colspan='2'><h2>Context Details </h2></th></tr>");
		out.println("<tr><th colspan='2'><h3>Context Paraneters Details </h3></th></tr>");
		out.println("<tr><td>logical Name</td><td>"+lname+"</td></tr>");
		out.println("<tr><td>Driver Class</td><td>"+driverClass+"</td></tr>");
		out.println("<tr><td>Driver URL</td><td>"+driverURL+"</td></tr>");
		out.println("<tr><td>DB UserName</td><td>"+db_username+"</td></tr>");
		out.println("<tr><td>DB Password</td><td>"+db_pwd+"</td></tr>");
		out.println("<tr><td>Parameter Names</td><td>"+paramNames+"</td></tr>");
		out.println("<tr><th colspan='2'><h3>Attribute Details</h3></th><tr>");
		out.println("<tr><td>a</td><td>"+context.getAttribute("a")+"</td></tr>");
		out.println("<tr><td>b</td><td>"+context.getAttribute("b")+"</td></tr>");
		out.println("<tr><td>c</td><td>"+context.getAttribute("c")+"</td></tr>");
		out.println("<tr><td>d</td><td>"+context.getAttribute("d")+"</td></tr>");
		Enumeration<String> e2 = context.getAttributeNames();
		String attributeName ="";
		while(e2.hasMoreElements()) {
			attributeName = attributeName +e2.hasMoreElements()+"<br>";
		}
		out.println("<tr><td>Attribute Name</td><td>"+attributeName+"</td><tr>");
		out.println("<tr><td>Foregine Context</td><td>"+context.getContext("/app14").getServletContextName()+"</td></tr>");
		out.println("</table></body></html>");
	}

}
