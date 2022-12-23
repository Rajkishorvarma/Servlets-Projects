package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		urlPatterns = { "/config" }, 
		initParams = { 
				@WebInitParam(name = "driverClass", value = "oracle.jdbc.OracleDriver"), 
				@WebInitParam(name = "driverURL", value = "jdbc:orcle:thin:@localhost:1521:xe"), 
				@WebInitParam(name = "dbUser", value = "system"), 
				@WebInitParam(name = "dbPwd", value = "rajkishor")
		})
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String lname =config.getServletName();
		String driverClass = config.getInitParameter("driverClass");
		String driverURL = config.getInitParameter("driverURL");
		String db_uname = config.getInitParameter("db_uname");
		String db_password = config.getInitParameter("db_password");
		Enumeration<String> e = config.getInitParameterNames();
		String paramNames = "";
		while(e.hasMoreElements()) {
			paramNames = paramNames + e.nextElement() +"<br>";
		}
		out.println("<html><body>");
		out.println("<table border ='1'>");
		out.println("<tr><th colspan='2'>Servlet Configration Detail</th><tr>");
		out.println("<tr><td>Driver Class</td><td>"+driverClass+"</td></tr>");
		out.println("<tr><td>Driver URL</td><td>"+driverURL+"</td></tr>");
		out.println("<tr><td>DB User Name</td><td>"+db_uname+"</td></tr>");
		out.println("<tr><td>DB Password</td><td>"+db_password+"</td></tr>");
		out.println("<tr><td>Init param Names</td><td>"+paramNames+"</td></tr>");
		out.println("<tr><td>Logical Name</td><td>"+lname+"</td></tr>");
		out.println("</table></body></html>");
	}

}
