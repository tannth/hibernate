package s21_mappingset_xml;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		HashSet<String> set1 = new HashSet<String>();
		set1.add("java is a programming language");
		set1.add("java is a platform");

		HashSet<String> set2 = new HashSet<String>();
		set2.add("Servlet is an Interface");
		set2.add("Servlet is an API");

		Question question1 = new Question();
		question1.setQname("What is Java?");
		question1.setAnswers(set1);

		Question question2 = new Question();
		question2.setQname("What is Servlet?");
		question2.setAnswers(set2);

		session.persist(question1);
		session.persist(question2);

		t.commit();
		session.close();
		System.out.println("success");
	}

}
