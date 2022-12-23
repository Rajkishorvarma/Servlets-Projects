package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class WishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		String wish_message = "";
		if(hour<12)
		{
			wish_message = "Good Morning";
		}else if(hour<17 && hour>=21)
		{
			wish_message = "Good Afternoon";
		}else {
			wish_message = "Good Night";
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<font color='red' size='6'>");
		out.println("<b>");
		out.println("Hello User "+wish_message);;
		out.println("</b></font></body></html>");
	}

}
