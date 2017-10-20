package com.arun.c3p0;

/*  
 hibernate.c3p0.min_size – Minimum number of JDBC connections in the pool. Hibernate default: 1
 hibernate.c3p0.max_size – Maximum number of JDBC connections in the pool. Hibernate default: 100
 hibernate.c3p0.timeout – When an idle connection is removed from the pool (in second). Hibernate default: 0, never expire.
 hibernate.c3p0.max_statements – Number of prepared statements will be cached. Increase performance. Hibernate default: 0 , caching is disable.
 hibernate.c3p0.idle_test_period – idle time in seconds before a connection is automatically validated. Hibernate default: 0
 */

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.arun.helloworld.Employee;

public class C3PoMainClass {
	private void testC3P0() throws Exception {
		Configuration config = new Configuration();
		config.addProperties(this.c3p0Properies());
		config.addAnnotatedClass(Employee.class);

		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(config.getProperties());
		SessionFactory sessionFactory = config.buildSessionFactory(sb.build());
		Session s = sessionFactory.openSession();

		s.beginTransaction();
		Employee e = new Employee();
		e.setName("arun");
		s.save(e);
		s.getTransaction().commit();
		s.close();
		sessionFactory.close();
	}

	private Properties c3p0Properies() {
		Properties p = this.dbProperies();
		p.setProperty("hibernate.c3p0.min_size", "5");
		p.setProperty("hibernate.c3p0.max_size", "10");
		p.setProperty("hibernate.c3p0.timeout", "20");
		p.setProperty("hibernate.c3p0.max_statements", "50");
		p.setProperty("hibernate.c3p0.idle_test_period", "3000");
		return p;
	}

	private Properties dbProperies() {
		Properties p = new Properties();
		p.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
		p.setProperty("hibernate.dialect",
				"com.enigmabridge.hibernate.dialect.SQLiteDialect");
		p.setProperty("hibernate.connection.url",
				"jdbc:sqlite:E:\\arun files\\e books\\SpringHibernateDB\\hibernate_db.sqlite");
		p.setProperty("hibernate.connection.username", "sa");
		p.setProperty("hibernate.connection.password", "");
		p.setProperty("hibernate.hbm2ddl.auto", "create");
		p.setProperty("hibernate.show_sql", "true");
		return p;
	}

	public static void main(String[] args) {
		try {
			new C3PoMainClass().testC3P0();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
