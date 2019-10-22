package com.heraizen.webpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		out.print("<html>");
		out.print("<head><title>Welcome to scart</title></head>");
		out.print("<body>");
		
		if (username !=null && password !=null) {
			if (username.equals("deepu") && password.equals("123")) {
				HttpSession session = request.getSession();
				if(session.isNew()) {
					session.setAttribute("username", username);
				}
				response.sendRedirect("viewproducts");
			} else {
				out.print("<h3 style='color:red'>please provide valid credentials<h3>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		} else {
			out.print("<h3>username or password can,t be empty<h3>");
			out.print("<br>");
			out.print("<a href='./'>Login</a>");
		}

		out.print("</body>");
		out.print("</html>");

	}

}
