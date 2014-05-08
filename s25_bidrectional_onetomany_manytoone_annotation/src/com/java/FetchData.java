package com.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

public class FetchData {
	public static void main(String[] args) {
		Session session = new AnnotationConfiguration().configure()
				.buildSessionFactory().openSession();

		session.beginTransaction();

		Query query = session.createQuery("from Team");

		List<Team> list = query.list();
		Iterator<Team> itr = list.iterator();

		while (itr.hasNext()) {
			Team team = (Team) itr.next();
			System.out.println(team.getName());

			Set<Player> list1 = team.getPlayers();
			Iterator<Player> itr2 = list1.iterator();
			while (itr2.hasNext()) {
				Player player = (Player) itr2.next();
				System.out.println(player.getLastname());
			}
		}
	}
}
