package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeHttpSession
 */

@WebServlet("/WelcomeHttpSession")
public class WelcomeHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeHttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int timeout = 20;
		HttpSession session = request.getSession(false);
		if(session != null) {
			String user = (String)session.getAttribute("user");
			out.println("Hello" + user);
			out.println("<br>Session Id: " + session.getId());
			out.println("<br>Session Creation Time: " + new Date(session.getCreationTime()));
			out.println("<br>Last Accessed Time: " + new Date(session.getLastAccessedTime()));
			session.setMaxInactiveInterval(timeout);
			out.println("<br> max Inactive Interval: " + session.getMaxInactiveInterval());
			
			response.setHeader("Refresh", timeout + "; URL=timeout.html");
			
			
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
