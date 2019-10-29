package com.arun.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.arun.helloworld.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration cfg = new Configuration().configure();
				StandardServiceRegistryBuilder service = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties());
				sessionFactory = cfg.buildSessionFactory(service.build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	private static StandardServiceRegistry registry;

	public static SessionFactory getJavaConfigSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry builder
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Map<String, Object> settings = new HashMap<>();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/northwind");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				// Apply settings
				registryBuilder.applySettings(settings);

				// Create registry
				registry = registryBuilder.build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// add hibernate pojo classes
				sources.addAnnotatedClass(Employee.class);
				
				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static void shutdownJavaConfigSessionFactory() {
		if (registry != null) {
			System.err.println("Shuting down StandardServiceRegistry");
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
