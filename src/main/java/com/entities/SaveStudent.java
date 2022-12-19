package com.entities;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.conn.ConnectionProvider;

public class SaveStudent {
	public static void studentInsert(String stuname,String stuemail, long stuphone) {
		Transaction tx=null;
		try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			StudentList stu1=new StudentList(stuname,stuemail,stuphone);
			session.save(stu1);
			tx.commit();
			session.close();
	   } catch (Exception e) {
		   e.printStackTrace();
		   if (tx != null) {
			   tx.rollback();
		   }
	   }
	}

	public static ArrayList<StudentList> studentDisplay() {
		Transaction tx=null;
		ArrayList<StudentList> stulist=null;
		try {
			SessionFactory factory =  ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			stulist = (ArrayList<StudentList>) session.createCriteria(StudentList.class).list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return stulist;
	}
}
