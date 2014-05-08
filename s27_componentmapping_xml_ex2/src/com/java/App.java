package com.java;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		System.out.println("Hibernate component mapping");
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();

		session.beginTransaction();

		Address address = new Address();
		address.setAddress1("Address 1");
		address.setAddress2("Address 2");
		address.setAddress3("Address 3");

		Customer cust = new Customer();
		cust.setCustName("mkyong");
		cust.setAge(30);
		cust.setAddress(address);
		cust.setCreatedDate(new Date());
		cust.setCreatedBy("system");

		session.save(cust);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
