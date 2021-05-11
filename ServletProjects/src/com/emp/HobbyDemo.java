package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HobbyDemo
 */
@WebServlet("/HobbyDemo")
public class HobbyDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HobbyDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("name");
		String st[] = request.getParameterValues("c1");
		pw.println("<h1 style =color:green;>Hello" + uname + "Your hobbies as follows</h1>");
		for (String x : st) {
			pw.println("<h2>" + x + "</h2>");
		}
		pw.println("<h1 style =color:red>Thanking you </h1>");
	}
}
