package com.entities;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.conn.ConnectionProvider;

public class SaveClass {
	public static void classInsert(String cname) {
		Transaction tx=null;
		try {
			SessionFactory factory = ConnectionProvider.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();	 
			ClassList cls1=new ClassList(cname);
			session.save(cls1);
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}
	
	public static ArrayList<ClassList> classDisplay() {
		Transaction tx=null;
	    ArrayList<ClassList> clslist=null;
	    try {
	    	SessionFactory factory = ConnectionProvider.getFactory();
	    	Session session = factory.openSession();
	    	tx = session.beginTransaction();
			clslist = (ArrayList<ClassList>) session.createCriteria(ClassList.class).list();
			tx.commit();
			session.close();
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    	if (tx != null) {
	    		tx.rollback();
	    	}
	    }
	    return clslist;
	}

}
