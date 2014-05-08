package com.java;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Java is a programming language");
		list1.add("Java is a platform");
		list1.add("Java is Java");
		list1.add("Java is .Net");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Servlet is an Interface");
		list2.add("Servlet is an API");

		Question quesion1 = new Question();
		quesion1.setQname("What is Java?");
		quesion1.setAnswers(list1);

		Question quesion2 = new Question();
		quesion2.setQname("What is Servlet?");
		quesion2.setAnswers(list2);

		session.persist(quesion1);
		session.persist(quesion2);

		t.commit();
		session.close();
		System.out.println("success");
	}
}
