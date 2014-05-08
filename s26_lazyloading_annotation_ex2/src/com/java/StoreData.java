/*package com.java;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StoreData {
	public static void main(String[] args) {
		SessionFactory sf = Utility.getSessionFactory();
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();
		Course c1 = new Course();
		c1.setName("java");
		c1.setDuration(36);

		Course c2 = new Course();
		c2.setName("db");
		c2.setDuration(12);

		Course c3 = new Course();
		c3.setName(".net");
		c3.setDuration(24);

		Course c4 = new Course();
		c4.setName("design");
		c4.setDuration(10);
		ArrayList<Course> list1 = new ArrayList<Course>();
		list1.add(c1);
		list1.add(c2);
		list1.add(c3);
		list1.add(c4);

		ArrayList<Course> list2 = new ArrayList<Course>();
		list2.add(c1);
		list2.add(c3);
		Student s1 = new Student();
		s1.setName("student 1");
		s1.setC(list1);

		Student s2 = new Student();
		s2.setName("student 2");
		s2.setC(list2);

		s.persist(s1);
		s.persist(s2);
		tx.commit();
		// s.close();
		System.out.println("success");
	}
}
*/