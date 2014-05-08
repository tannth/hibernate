package com.java;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreTest {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();
		Transaction tx = session.beginTransaction();

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("java is a programming language", "John Milton");
		map1.put("java is a platform", "Ashok Kumar");

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("servlet technology is a server side programming",
				"John Milton");
		map2.put("Servlet is an Interface", "Ashok Kumar");
		map2.put("Servlet is a package", "Rahul Kumar");

		Question question1 = new Question("What is java?", "Alok", map1);
		Question question2 = new Question("What is servlet?", "Jai Dixit", map2);

		session.persist(question1);
		session.persist(question2);

		tx.commit();
		session.close();
		System.out.println("successfully stored");

	}

}
