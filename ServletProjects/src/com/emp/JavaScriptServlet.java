package com.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaScriptServlet
 */
@WebServlet("/JavaScriptServlet")
public class JavaScriptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaScriptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String name=request.getParameter("s1");
			if(name.equals("AndhraPradesh")){
				pw.println("<h2 style=color:green> your select state is:"+name+"</h2><br>");
				pw.println("<h2 style style=color:maroon>"+"Capital=Amaravathi</h2>");
			}
			else if(name.equals("Telangana")){
				pw.println("<h2 style=color:green> your select state is:"+name+"</h2><br>");
				pw.println("<h2 style style=color:maroon>"+"Capital=Amaravathi</h2>");
			}
//			else {
//				pw.println("<h2 style=color:green> your select state is:</h2><br>");
//				//pw.println("<h2 style style=color:maroon>"+"Capital=Amaravathi</h2>");
//		}
		
	}

	

}
