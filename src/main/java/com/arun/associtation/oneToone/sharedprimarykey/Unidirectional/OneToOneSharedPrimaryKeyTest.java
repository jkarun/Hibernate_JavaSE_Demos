package com.arun.associtation.oneToone.sharedprimarykey.Unidirectional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arun.util.HibernateUtil;

public class OneToOneSharedPrimaryKeyTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		Adreess_sharedPrimaryKey add = new Adreess_sharedPrimaryKey("Some Street 123", "12345", "Some City");
		
		session.persist(add); // generate ID value
		User_sharedPrimaryKey user = new User_sharedPrimaryKey(
				add.getId(), // assign same ID value
				"arun"
				);
		user.setAddress(add);
		session.persist(user);
		
		session.getTransaction().commit();
		
		List<Adreess_sharedPrimaryKey> ad = (List<Adreess_sharedPrimaryKey>)session.createQuery("from Adreess_sharedPrimaryKey").list();
		List<User_sharedPrimaryKey> us = (List<User_sharedPrimaryKey>) session.createQuery("from User_sharedPrimaryKey").list();

		System.out.println("========================== Address ===================");
		for(Adreess_sharedPrimaryKey a : ad)
			System.out.println(a);
		System.out.println("========================== User ===================");
		for(User_sharedPrimaryKey a : us)
			System.out.println(a);
		
	    session.close();
	}

}
