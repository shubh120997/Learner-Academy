package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Home() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out=res.getWriter();
		RequestDispatcher rd = null;
		try {	
			Home loginObj = new Home();
			if(loginObj.userLogin(username, password)) {
				HttpSession session=req.getSession();
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60);
				rd=req.getRequestDispatcher("/Dashboard.html");
				rd.forward(req, res);
			}
		} catch (Exception e) {
			rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);	
			out.print("<center><span style='color:red'>"+e.getMessage()+"</span></center>");
		}
	}
	
	boolean userLogin(String username, String password) throws Exception {
		if(!username.isEmpty() && !password.isEmpty()){
			if(username.matches("spnobody") && password.matches("98765"))
				return true;
			else {throw new Exception("Invalid Credentials");}
		}
		else {throw new Exception("Username, Password cannot be null");}
	}
}
