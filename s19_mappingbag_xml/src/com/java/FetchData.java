package com.java;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();

		Query query = session.createQuery("from Question");

		List<Question> list = query.list();

		Iterator<Question> itr = list.iterator();

		while (itr.hasNext()) {
			Question question = (Question) itr.next();
			System.out.println("Questtion name: " + question.getQname());

			List<String> list2 = question.getAnswers();
			Iterator<String> itr2 = list2.iterator();
			while (itr2.hasNext()) {
				String string = (String) itr2.next();
				System.out.println(string);
			}
		}
		session.close();
		System.out.println("success");
	}

}
