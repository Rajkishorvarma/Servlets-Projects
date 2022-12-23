package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasoft.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		UserService us = new UserService();
		String status = us.checkLogin(uname, upwd);
		
		out.println("<html>");
		out.println("<body bgcolor='lightblue'><br><br><br>");
		out.println("<h1 style='color:red;' align='center'>");
		if(status.equals("success")) {
			out.println("User Login Success");
		}else {
			out.println("User Login Failure");
		}
		out.println("</h1></body></html>");
	}

}
