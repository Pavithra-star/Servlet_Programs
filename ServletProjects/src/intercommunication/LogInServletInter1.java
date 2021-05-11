package intercommunication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInServletInter1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogInServletInter1() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");

		request.setAttribute("username", uname);
		request.setAttribute("password", upass);

		RequestDispatcher rd = request.getRequestDispatcher("/LogInServletInter2");
		pw.println("<h3 style = color:blue> From first servlet</h3>");
		//rd.include(request, response);
		rd.forward(request, response);
		pw.println("<h4 dtyle=color:green>Date:" + new java.util.Date() + "</h4>");

	}

}
