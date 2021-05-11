package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
import com.data.model.Person;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	PersonDao personDao;
    public UserRegisterServlet() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		 personDao=new PersonDao();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String ename=request.getParameter("ename");
		String contactno=request.getParameter("contactno");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
     Person p=new Person();
		p.setEname(ename);
		p.setContactno(contactno);
		p.setEmail(email);
		p.setGender(gender);
		p.setAddress(address);
		if(PersonDao.addPerson(p)) {
			
			pw.println("<h1 style=background-color:maroon;color:white;padding:20px; text-align:center;> Your registration has been done successfully</h1>");
		}//style=background-color:maroon;color:white;padding:20px; text-align:center; Your registration has been done successfully
		else {
			System.out.println("not sorted");
			//pw.println("<h1 style=background-color:maroon;color:white;padding:20px; text-align:center;> Your registration has been done successfully</h1>");
		}
		System.out.println("sorted");
		
		
	}

	

}
