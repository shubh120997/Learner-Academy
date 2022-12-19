package com.entities;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.conn.ConnectionProvider;

public class SaveSubject {
	public static void subjectInsert(String subname) {
        Transaction tx=null;
	    try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();		 
			SubjectList sub1=new SubjectList(subname);
			session.save(sub1);
			tx.commit();
			session.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (tx != null) {
	    		tx.rollback();
	    	}
	    }
	}
	
	public static ArrayList<SubjectList> subjectDisplay() {
		Transaction tx=null;
		ArrayList<SubjectList> sublist=null;
		try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			sublist = (ArrayList<SubjectList>) session.createCriteria(SubjectList.class).list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return sublist;
	}
}
