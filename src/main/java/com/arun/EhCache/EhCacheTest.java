package com.arun.EhCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arun.util.HibernateUtil;

public class EhCacheTest {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
//		session.getTransaction().begin();
		session.beginTransaction();
		//save default data
			Country c1 = new Country( "INDIA", "IN");
			session.persist(c1);
			Country c2 = new Country( "United States of America", "US");
			session.persist(c2);
			Country c3 = new Country( "United Kindom", "UK");
			session.persist(c3);
		session.getTransaction().commit();
		session.close();
		
		testCache(factory);
	}

	private static void testCache(SessionFactory factory){
		
		Session s1 = factory.openSession();
		s1.getTransaction().begin();
		Country a = (Country) s1.load(Country.class, 1);
		System.out.println(a);
		s1.close();
		
		Session s2 = factory.openSession();
		s2.getTransaction().begin();
		Country b = (Country) s2.load(Country.class, 1);
		System.out.println(b);
		s2.close();
		
		Session s3 = factory.openSession();
		s3.getTransaction().begin();
		Country c = (Country) s3.load(Country.class, 1);
		System.out.println(c);
		s3.close();
		
		/*Session s4 = factory.openSession();
		s4.getTransaction().begin();
		Country d = (Country) s4.load(Country.class, 2);
		System.out.println(d);
		s4.close();*/
		
	}
	
}
