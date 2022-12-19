package com.servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.SaveTeacher;

public class AddTeach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddTeach() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String Tname = req.getParameter("teacherName");		
		SaveTeacher.teacherInsert(Tname);
		RequestDispatcher  rd= getServletContext().getRequestDispatcher("/ViewTeacher.jsp");
		rd.forward(req, res);
	}
}
