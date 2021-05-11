package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
import com.dao.PersonDaoUpdate;
import com.dao.PersonDelDao;
import com.data.model.Person;


public class PersonUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDaoUpdate persondao;
    public void init(ServletConfig config)throws ServletException {
    	persondao = new  PersonDaoUpdate();
    }
    public PersonUpdateServlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		int num=Integer.parseInt(request.getParameter("no"));
		String ename=request.getParameter("ename");
		String contactno=request.getParameter("contactno");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		pw.println("<html><head><style type=text/css>");
		pw.println("table{ width:50%; border-collapse: collapse;background-color:wheat;");
		pw.println("border-spacing:10px;} table, tr, td{border:1px soild blue;} th,td{");
		pw.println("padding:20px;} </style></head><body>");
		pw.println("<form action =PersonUpdateServlet method=POST> ");
		pw.println("<h1 style=backgraound-color:marron;");
		pw.println("color:white;padding:20 px;text-align;center;>");
		pw.println("Welcome to Registration Page</h1>");
		pw.println("<table align =center ><tr>");
		pw.println("<input type=hidden name=pid value="+num+">");
		pw.println("<td>Enter Name:</td>");
		pw.println("<td><input type= text name=ename value="+ename+"></td>");
		pw.println("</tr><tr><td>Enter contact Number:</td>");
		pw.println("<td><input type= text name=contactno value="+contactno+"></td>");
		pw.println("</tr><tr><td>Email Id:</td>");
		pw.println("<td><input type =text name=email value="+email+"></td>");
		pw.println("</tr><tr><td>Gender</td><td>");
		if(gender.equals("Male")) {
			pw.println("<input type=radio name=gender value=on>Male");
			pw.println("<input type=radio name=gender value=off>Female</td>");
		}
		else {
			pw.println("<input type= radio name=gender value=off>Male");
			pw.println("<input type=radio name=gender value=on>Female</td>");
			
		}
		
		pw.println("</tr><tr><td>Address:</td><td>");
		pw.println("<textarea name=address rows=5 cols=20>"+address+"</textarea></td>");
		pw.println("</tr><tr><td colspan=2 align=center><input type= submit value =click></td></tr>");
		pw.println("</table></form></body></html>");
		
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int num=Integer.parseInt(request.getParameter("pid"));
		String ename=request.getParameter("ename");
		String contactno=request.getParameter("contactno");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		Person person=new Person();
		person.setPid(num);
		person.setEname(ename);
		person.setContactno(contactno);
		person.setEmail(email);
		person.setGender(gender);
		person.setAddress(address);
		if(persondao.updatePerson(person)) {
			pw.println("<h3 style=color:blue>Update Successfullt</h3>");
		}
		else {
			pw.println("<h3 style =color:red>Try again</h3>");
		}
	}

	
}



