 package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String[] qual = request.getParameterValues("uqual");
		String uqual ="";
		for(String s: qual) {
			uqual=uqual+s+"<br>";
		}
		String ugender = request.getParameter("ugender");
		String[] techs = request.getParameterValues("utech");
		String utech ="";
		for(String s:techs) {
			utech = utech + s+"<br>";
		}
		String uprof = request.getParameter("uprof");
		String uaddr = request.getParameter("uaddr");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color:red;'align='center'>Durga Software Solution</h1>");
		out.println("<h3 style='color:blue;' align='center'>User registration Details</h3>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><td>User Name</td><td>"+uname+"</td></tr>");
		out.println("<tr><td>User Qualification</td><td>"+uqual+"</td></tr>");
		out.println("<tr><td>Gender</td><td>"+ugender+"</td></tr>");
		out.println("<tr><td>User Technologies</td><td>"+utech+"</td></tr>");
		out.println("<tr><td>User Profession</td><td>"+uprof+"</td></tr>");
		out.println("<tr><td>User Address</td><td>"+uaddr+"</td></tr>");
		out.println("</table>");
		out.println("<h3 align='center'><a herf='./user_Reg_form.html'>|User Registeration Form|</a></h3>");
		out.println("</body></html>");
	}

}
