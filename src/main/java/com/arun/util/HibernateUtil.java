package com.arun.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure();
			StandardServiceRegistryBuilder service = new StandardServiceRegistryBuilder()
			.applySettings(cfg.getProperties());
			sessionFactory = cfg.buildSessionFactory(service.build());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
