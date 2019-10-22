package com.heraizen.webpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heraizen.webpage.service.ProductService;

/**
 * Servlet implementation class ViewProducts
 */
@WebServlet("/viewproducts")
public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> productsNames = ProductService.getProductNames();
		PrintWriter out = response.getWriter();
		String username = null;
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("username")==null) {
			response.sendRedirect("index.jsp");
		}else {
			username = (String) session.getAttribute("username");
		}
		out.print("<html>");
		out.print("<head><title>Welcome to scart</title></head>");
		out.print("<body>");
		out.print("<p>welcome user : &nbsp;" + username);
		out.print("&nbsp;&nbsp; <a href='logout'> Logout</a>" + "</p>");
		for (String pname : productsNames) {
			out.print("<li>" + pname + "</li>");
		}

		out.print("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
