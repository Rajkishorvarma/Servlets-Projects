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
				@WebInitParam(name = "a", value = "apple"), 
				@WebInitParam(name = "b", value = "boy"), 
				@WebInitParam(name = "c", value = "cow")
		})
public class MycontextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		ServletContext context =  getServletConfig().getServletContext();
		String lname = context.getServletContextName();
		String a = context.getInitParameter("a");
		String b = context.getInitParameter("b");
		String c = context.getInitParameter("c");
		Enumeration<String> e1 = context.getInitParameterNames();
		String paramNames = "";
		while(e1.hasMoreElements()) {
			paramNames = paramNames + e1.nextElement() +"<b>";
		}
		context.setAttribute("d", "dog");
		context.setAttribute("e", "enjoy");
		context.setAttribute("f", "funny");
		context.setAttribute("g", "gunny");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th colspan='2'><h2>Context Details </h2></th></tr>");
		out.println("<tr><th colspan='2'><h3>Context Parameters Details </h3></th></tr>");
		out.println("<tr><td>logical Name</td><td>"+lname+"</td></tr>");
		out.println("<tr><td>a</td><td>"+a+"</td></tr>");
		out.println("<tr><td>b</td><td>"+b+"</td></tr>");
		out.println("<tr><td>c</td><td>"+c+"</td></tr>");
		out.println("<tr><td>Parameter Names</td><td>"+paramNames+"</td></tr>");
		out.println("<tr><th colspan='2'><h3>Context Attribute Details</h3></th><tr>");
		out.println("<tr><td>d</td><td>"+context.getAttribute("d")+"</td></tr>");
		out.println("<tr><td>e</td><td>"+context.getAttribute("e")+"</td></tr>");
		out.println("<tr><td>f</td><td>"+context.getAttribute("f")+"</td></tr>");
		out.println("<tr><td>g</td><td>"+context.getAttribute("g")+"</td></tr>");
		/*Enumeration<String> e2 = context.getAttributeNames();
		String attributeName ="";
		while(e2.hasMoreElements()) {
			attributeName = attributeName +e2.nextElement()+"<br>";
		}
		out.println("<tr><td>Attribute Name</td><td>"+attributeName+"</td><tr>");*/
		out.println("</table></body></html>");
	}

}
