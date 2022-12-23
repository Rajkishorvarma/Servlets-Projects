package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasoft.beans.Student;
import com.durgasoft.service.StudentService;

@WebServlet("/edit")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("sid");
		StudentService stds = new StudentService();
		Student std = stds.getStudent(sid);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2 style='color:red;' align='center'>DURGA SOFTWARE SOLUTIONS</h2>");
		if (std==null) {
			out.println("<h3 style='color:blue;' align='center'>Students Updation Status</h3>");
			out.println("<h1 style='color:red;' align='center'>Student Not Existed</h1>");
			out.println("<h3 align='center'><a href='./updateform.html'>|Student Update Form|</a></h3>");
		}else {
			out.println("<h3 style='color:blue;' align='center'>Student Edit Form</h3><br><br>");
			out.println("<form method='post' action='./update'>");
			out.println("<table align='center'>");
			out.println("<tr><td>Student Id:</td><td>"+sid+"</td></tr>");
			out.println("<input type='hidden' name='sid' value='"+sid+"'/>");
			out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+std.getSname()+"'/></td></tr>");
			out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value='"+std.getSaddr()+"'/></td></tr>");
			out.println("<tr><td><input type='submit' value='Update'/></td></tr>");
			out.println("</table></form>");
		}
		out.println("</body></html>");
	}

}
