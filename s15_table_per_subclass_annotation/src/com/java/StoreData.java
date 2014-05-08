package com.java;

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

		Employee e1 = new Employee();
		e1.setName("tan");

		Regular_Employee e2 = new Regular_Employee();
		e2.setName("tan2");
		e2.setBonus(5);
		e2.setSalary(5000);

		Contract_Employee e3 = new Contract_Employee();
		e3.setName("tan3");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");
		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();

		System.out.println("success");

	}
}
