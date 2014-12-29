package com.hibernate.tutorial;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.persistence.HibernatePersistence;

public class Main {

	public static void main(String[] args) {
		Session session = HibernatePersistence.getSessionFactory()
				.openSession();

		session.beginTransaction();

		Query query = session.createQuery("from ZipCodes");

		List<ZipCodes> zipCodesList = query.list();
		for (ZipCodes z : zipCodesList) {
			System.out.println(+z.getId() + "," + z.getZipCode());
		}

		//
		// close session
		HibernatePersistence.shutdown();
	}
}