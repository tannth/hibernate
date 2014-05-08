package com.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchData {
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory().openSession();

		Query query = session.createQuery("from Question");

		List<Question> list = query.list();

		Iterator<Question> itr = list.iterator();

		while (itr.hasNext()) {
			Question question = (Question) itr.next();
			System.out.println("Questtion name: " + question.getQname());

			Set<Answer> list2 = question.getAnswers();
			Iterator<Answer> itr2 = list2.iterator();
			while (itr2.hasNext()) {
				Answer string = (Answer) itr2.next();
				System.out.println(string);
			}
		}
		session.close();
		System.out.println("success");
	}
}
