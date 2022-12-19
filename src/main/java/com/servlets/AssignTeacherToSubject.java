package com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.conn.ConnectionProvider;
import com.entities.TeacherList;

public class AssignTeacherToSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AssignTeacherToSubject() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		Transaction tx = null;
		String tname = req.getParameter("name");
		String subject = req.getParameter("subject");
		try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			String hql_teacher= "from TeacherList  where tname='" + tname + "'";
			List<TeacherList> tea = session.createQuery(hql_teacher).list();
			TeacherList x=tea.get(0);
			System.out.println("hello"+x);
			String qryString3 = "update SubjectList  s set s.TeacherList =:n where s.Subname=:sn";
	        Query query3 = session.createQuery(qryString3);
	        query3.setParameter("n", tea.get(0));
			query3.setParameter("sn",subject );
	        query3.executeUpdate();
		
			tx.commit();
			session.close();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewTeacherSubject.jsp");
	        dispatcher.forward(req, res); 
		   }
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}
