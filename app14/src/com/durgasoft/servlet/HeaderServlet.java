package com.durgasoft.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		Enumeration<String> e = request.getHeaderNames();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th colspan='2'>Request Headers Data</th><tr>");
		while (e.hasMoreElements()) {
			String headerName = e.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println("<tr>");
			out.println("<th>"+headerName+"</th>");
			out.println("<th>"+headerValue+"</th>");
			out.println("</tr>");
			}
		out.println("</table></body></html>");
	}

}
