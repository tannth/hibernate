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
			System.out.println("answers.....");
			Map<String, User> map = question.getAnswers();
			Set<Map.Entry<String, User>> set = map.entrySet();

			Iterator<Map.Entry<String, User>> iteratoranswer = set.iterator();
			while (iteratoranswer.hasNext()) {
				Map.Entry<String, User> entry = (Map.Entry<String, User>) iteratoranswer
						.next();
				System.out.println("answer name:" + entry.getKey());
				System.out.println("answer posted by.........");
				User user = entry.getValue();
				System.out.println("username:" + user.getUsername());
				System.out.println("user emailid:" + user.getEmail());
				System.out.println("user country:" + user.getCountry());
			}
		}
		session.close();
	}

}
