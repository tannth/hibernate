package com.java;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		Session session = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml").buildSessionFactory()
				.openSession();
		Transaction t = session.beginTransaction();

		Question question1 = new Question();
		question1.setQname("What is Java?");

		Question question2 = new Question();
		question2.setQname("What is Servlet?");

		Answer ans1 = new Answer();
		ans1.setAnswer("java is a programming language");
		ans1.setPostName("Ravi Malik");
		

		Answer ans2 = new Answer();
		ans2.setAnswer("java is a platform");
		ans2.setPostName("Sudhir Kumar");
	

		Answer ans3 = new Answer();
		ans3.setAnswer("Servlet is an Interface");
		ans3.setPostName("Jai Kumar");
		

		Answer ans4 = new Answer();
		ans4.setAnswer("Servlet is an API");
		ans4.setPostName("Arun");
		

		ArrayList<Answer> list1 = new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		ArrayList<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);

		question1.setAnswers(list1);

		question2.setAnswers(list2);

		session.persist(question1);
		session.persist(question2);

		t.commit();
		session.close();
		System.out.println("success");
	}

}
