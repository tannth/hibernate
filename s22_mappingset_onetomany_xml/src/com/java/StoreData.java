package com.java;

import java.util.ArrayList;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		Answer ans1 = new Answer();
		ans1.setAnswer("java is a programming language");
		ans1.setPostBy("Ravi Malik");

		Answer ans2 = new Answer();
		ans2.setAnswer("java is a platform");
		ans2.setPostBy("Sudhir Kumar");

		Answer ans3 = new Answer();
		ans3.setAnswer("Servlet is an Interface");
		ans3.setPostBy("Jai Kumar");

		Answer ans4 = new Answer();
		ans4.setAnswer("Servlet is an API");
		ans4.setPostBy("Arun");

		HashSet<Answer> list1 = new HashSet<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		HashSet<Answer> list2 = new HashSet<Answer>();
		list2.add(ans3);
		list2.add(ans4);

		Question question1 = new Question();
		question1.setQname("What is Java?");
		question1.setAnswers(list1);

		Question question2 = new Question();
		question2.setQname("What is Servlet?");
		question2.setAnswers(list2);

		session.persist(question1);
		session.persist(question2);

		t.commit();
		session.close();
		System.out.println("success");
	}

}
