package com.java;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {

		Session session = new AnnotationConfiguration().configure()
				.buildSessionFactory().openSession();

		session.beginTransaction();

		Team team = new Team("Barcelona");
		Set<Player> players = new HashSet<Player>();

		Player p1 = new Player("Messi");
		Player p2 = new Player("Xavi");

		p1.setTeam(team);
		p2.setTeam(team);

		players.add(p1);
		players.add(p2);

		team.setPlayers(players);

		session.save(team);

		session.getTransaction().commit();

		session.close();
		System.out.println("success");
	}

}
