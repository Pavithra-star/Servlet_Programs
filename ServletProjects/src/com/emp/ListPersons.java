package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDAO_Retrieve;
import com.data.model.Person;

@WebServlet("/ListPersons")
public class ListPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    public ListPersons() {
        super();
       
    }

    PersonDAO_Retrieve personDAO;
	public void init(ServletConfig config) throws ServletException {
		personDAO =new PersonDAO_Retrieve();
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		List<Person> list=personDAO.ListPerson();
		pw.println("<html><head><style type=text/css>");
		pw.println("table{ width:50%; border-collapse: collapse;");
		pw.println("background-color:wheat;border-spacing:10px;}");
		pw.println("table,tr,td { border : 1px solis blue;}");
		pw.println("th,td {padding:20px;}");
		pw.println("</style></head><body>");
		pw.println("<form action=#>");
		pw.println("<h style=backgraound-color:marron;color:white;padding:20 px;");
		pw.println("<text-align;center;>ListPersons </h1>");
		pw.println("<table align=center>");
		pw.println("<tr>");
		for(Person p:list) {
			int num=p.getPid();
			pw.println("<td>"+num+"</td>");
			pw.println("<td>"+p.getEname()+"</td>");
			pw.println("<td>"+p.getContactno()+"</td>");
			pw.println("<td>"+p.getEmail()+"</td>");
			pw.println("<td>"+p.getGender()+"</td>");
			pw.println("<td>"+p.getAddress()+"</td>");
			pw.println("<td> <a href=PersonDel_Servlet?no="+num+"> delete </a></td>");
			pw.println("<tr");
		}
		pw.println("</table> </form></body></html>");
		}
		
	}

