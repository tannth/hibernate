package com.java;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Query query = session.createQuery("from Employee e");
		List<Employee> list = query.list();

		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println(emp.getEmployeeId() + " " + emp.getName() + " "
					+ emp.getEmail());
			Address address = emp.getAddress();
			System.out.println(address.getAddressLine1() + " "
					+ address.getCity() + " " + address.getState() + " "
					+ address.getCountry());
		}

		session.close();
		System.out.println("success");
	}

}
