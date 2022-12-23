package com.durgasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasoft.beans.Student;
import com.durgasoft.service.StudentService;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		
		Student student = new  Student();
		student.setSid(sid);
		student.setSname(sname);
		student.setSaddr(saddr);
		
		StudentService sts = new StudentService();
		sts.add(student);
		ArrayList<Student> studentList = sts.getAllStudent();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2 style='color:red;' align='center'>Durga Software Solutions</h2>");
		out.println("<h3 style='color:blue;' align='center'>Student Details</h3>");
		out.println("<table align ='center' border='2'>");
		out.println("<tr><th>SID</th><th>SNAME</th><th>SADDR</th></tr>");
		for(Student std: studentList) {
			out.println("<tr>");
			out.println("<td>"+std.getSid()+"</td>");
			out.println("<td>"+std.getSname()+"</td>");
			out.println("<td>"+std.getSaddr()+"</td>");
			out.println("</tr>");
		}
		out.println("</table></body></html>");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("std_add_form.html");
		requestDispatcher.include(request, response);
	}
}
