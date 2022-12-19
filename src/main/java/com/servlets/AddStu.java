package com.servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.SaveStudent;

public class AddStu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddStu() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String stuname = req.getParameter("studentName");
		String stuemail = req.getParameter("studentMail");
		long stuphone = Long.parseLong(req.getParameter("studentMobile"));
		SaveStudent.studentInsert(stuname,stuemail,stuphone);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewStudent.jsp");
		rd.forward(req, res); 
	}
}
