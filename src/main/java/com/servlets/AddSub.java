package com.servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.SaveSubject;

public class AddSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddSub() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String Subname = req.getParameter("subjectName");
		SaveSubject.subjectInsert(Subname);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewSubject.jsp");
		rd.forward(req, res);
	}
}
