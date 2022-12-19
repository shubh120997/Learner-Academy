package com.entities;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.conn.ConnectionProvider;

public class SaveTeacher {
	public static void teacherInsert(String Tname) {
        Transaction tx=null;
	    try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			TeacherList tea1=new TeacherList(Tname);
			session.save(tea1);
			tx.commit();
			session.close();
	    } catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	public static ArrayList<TeacherList>  teacherDisplay() {
		Transaction tx=null;
		ArrayList<TeacherList> tealist=null;
		try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			tealist = (ArrayList<TeacherList>) session.createCriteria(TeacherList.class).list();
			tx.commit();
			session.close();
		 } catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		 }
		return tealist;
	}
}
