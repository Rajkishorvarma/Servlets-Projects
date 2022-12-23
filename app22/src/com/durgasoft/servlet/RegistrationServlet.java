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
		
		String sname = request.getParameter("sname");
		String squal = request.getParameter("squal");
		String scourse = request.getParameter("scourse");
		String semail = request.getParameter("semail");
		String smobile= request.getParameter("smobile");
		boolean flag =true;
		if (squal.equals("MBA")) {
			if (!scourse.equals("SAP")) {
				flag=false;
			}
		}
		if(squal.equals("CA")){
			if(!scourse.equals("TALLY")) {
				flag=false;
			}
		}
		if(squal.equals("BCA")||squal.equals("MCA")||squal.equals("B.TECH")||squal.equals("M.TECH")) {
			if(scourse.equals("SAP")||scourse.equals("TALLY")) {
				flag=false;
			}
		}
		if (flag==true) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h2 style='color:red;' align='center'>Durga Software Solutions</h2>");
			out.println("<h3 style='color:green;' align='center'>Course Registration Details</h3>");
			out.println("<table align='center' border='1'>");
			out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
			out.println("<tr><td>Student Qualification</td><td>"+squal+"</td></tr>");
			out.println("<tr><td>Student Course</td><td>"+scourse+"</td></tr>");
			out.println("<tr><td>Student Email</td><td>"+semail+"</td></tr>");
			out.println("<tr><td>Student Mobile</td><td>"+smobile+"</td></tr>");
			out.println("</table>");
			out.println("<h3 style='color:blue' align='center'><a href='./course_reg_form.html'>|Course Registration Details|</a></h3>");
			out.println("</body></html>");
		}else {
			response.sendError(506,"Your Qualification is "+squal+" and you are not Eligible for the course"+scourse);
		}
	}

}
