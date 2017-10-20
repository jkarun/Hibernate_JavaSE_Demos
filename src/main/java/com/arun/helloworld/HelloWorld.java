package com.arun.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HelloWorld {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		//cfg.addAnnotatedClass(Employee.class);
		cfg.configure();
		StandardServiceRegistryBuilder service = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());
		
		SessionFactory factory = cfg.buildSessionFactory(service.build());
		Session session = factory.openSession();
		//Transaction tx = session.beginTransaction();
		session.beginTransaction();

		Employee e = new Employee();
		e.setName("agi");
		session.save(e);
		
		Employee a = new Employee();
		a.setName("arun");
		session.save(a);
		
		session.getTransaction().commit();
		session.close();
	}
}
