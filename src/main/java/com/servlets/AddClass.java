package com.servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.SaveClass;

public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddClass() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html");
         String className = req.getParameter("className");
         SaveClass.classInsert(className);
         RequestDispatcher  rd = getServletContext().getRequestDispatcher("/ViewClass.jsp");
	     rd.forward(req, res);
	}
}
