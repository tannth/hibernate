package com.java;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class FetchData {
	public static void main(String[] args) {
		SessionFactory sf = Utility.getSessionFactory();
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Student st1 = (Student) s.get(Student.class, 1l);

		List<Course> c1 = st1.getC();

		for (int i = 0; i < c1.size(); i++) {
			System.out.println(c1.get(i).getName());
		}
		tx.commit();
	}
}
