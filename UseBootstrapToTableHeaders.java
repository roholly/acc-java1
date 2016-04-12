package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UseBootstrapToTableHeaders
 */
@WebServlet("/UseBootstrapToTableHeaders")
public class UseBootstrapToTableHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseBootstrapToTableHeaders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.print("<link rel=\"stylesheet\" href=\"bootstrap-3.3.6-dist/css/bootstrap.min.css\">");
		out.print("</head><body>");
		// Next line not required to generate table:  Just makes "pretty."
		out.print("<table class=\"table table-hover\">");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>Header Name</th><th>Value</th>");
		out.print("</tr>");
		out.print("</thead>");
	    out.print("<tbody>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements())  {
			String key = headerNames.nextElement();
			String val = request.getHeader(key);
			out.print("<tr><td>" + key + "</td><td>" + val + "</td></tr>");			
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body></html>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
