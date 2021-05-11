package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDelDao;

@WebServlet("/PersonDel_Servlet")
public class PersonDel_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonDel_Servlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int value = Integer.parseInt(request.getParameter("no"));
		PersonDelDao persondao = new PersonDelDao();
		if (persondao.delPerson(value)) {
			response.sendRedirect("./ListPersons");
		} else {
			pw.println("<h3 style =color:red> Try Again</h3>");
		}
	}

}
