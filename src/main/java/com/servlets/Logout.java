package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(false);
		RequestDispatcher rd = null;
		if(session==null) {
			rd=req.getRequestDispatcher("/login.html");
			rd.include(req, res);
			out.print("<center><span style='color:red'>Please login first.</span></center>");	
		}
		else {
			session.invalidate();
			out.print("<center><h3>You have been logged out successfully.. Navigating you to home page.....</h3></center>");
			res.setHeader("refresh", "5;http://localhost:8080/Learner-Academy/");
		}
	}
}
