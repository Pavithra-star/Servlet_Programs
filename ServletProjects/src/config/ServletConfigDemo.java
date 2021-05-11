package config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigDemo
 */
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String cnames = null;
	public ServletConfigDemo() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		cnames = config.getInitParameter("cnames");
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=wheat text =blue>");
		pw.println("<form action =ServletConfigDemo method=POST>");
		pw.println("<h1 style=color:maroon> Online Courses</h1><hr>");
		pw.println("<p>Select course name:</p>");
		pw.println("<p>Select name= cname</p>");
		String cn[] = cnames.split(",");
		for(String x:cn) {
			pw.println("<option>"+ x+ "</option>");
		}
		pw.println("</select></p>");
		pw.println("<p><input type=submit value = Register></p></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String sc[]= {"JAVA",".NET","PYTHON","TESTING","ORACLE"};//JAVA,.NET,PYTHON,TESTRING,ORACLE
		double prices[] = {25000.00,20000.00,15000.00,18000.00};
		String cname = request.getParameter("cname");
		int ind = 0;
		for(int i = 0 ;i < sc.length;i++) {
			if(cname.equalsIgnoreCase(sc[i])) {
			ind = i;
		}
	}
	pw.println("<h1 style=color:green>Your Select Course Name:"+cname +"<br>");
	pw.println("you have to pay  "+prices[ind]+"Rs.only</h1>");
	pw.println("<h4 style = color:red>Thnaking you </h4>");
	
	}

}
