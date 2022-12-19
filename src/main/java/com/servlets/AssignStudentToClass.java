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
import com.entities.ClassList;
import com.conn.ConnectionProvider;

public class AssignStudentToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AssignStudentToClass() {
        super();
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");	
		Transaction tx=null;
		String sname = req.getParameter("name");
		String classes = req.getParameter("class");
		try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			String hql_classes= "from ClassList where cname='" + classes + "'";		
			List<ClassList> clas = session.createQuery(hql_classes).list();
			ClassList x=clas.get(0);
			System.out.println("hello"+x);
			String qryString3 = "update StudentList  s set s.ClassList=:n where s.Sname=:sn";
	        Query query3 = session.createQuery(qryString3);
	        query3.setParameter("n", clas.get(0));
			query3.setParameter("sn",sname );
	        query3.executeUpdate();
		
			tx.commit();
			session.close();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewStudentClass.jsp");
	        dispatcher.forward(req, res);
	    } catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}
