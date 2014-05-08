package com.java;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchTest {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();

		Query query = session.createQuery("from Question ");
		List<Question> list = query.list();

		Iterator<Question> iterator = list.iterator();
		while (iterator.hasNext()) {
			Question question = iterator.next();
			System.out.println("question id:" + question.getId());
			System.out.println("question name:" + question.getName());
			System.out.println("question posted by:" + question.getUsername());
			System.out.println("answers.....");
			Map<String, String> map = question.getAnswers();
			Set<Map.Entry<String, String>> set = map.entrySet();

			Iterator<Map.Entry<String, String>> iteratoranswer = set.iterator();
			while (iteratoranswer.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) iteratoranswer
						.next();
				System.out.println("answer name:" + entry.getKey());
				System.out.println("answer posted by:" + entry.getValue());
			}
		}
		session.close();
	}

}
