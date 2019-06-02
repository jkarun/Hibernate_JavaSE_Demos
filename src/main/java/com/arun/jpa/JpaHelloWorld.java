package com.arun.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHelloWorld {
	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jpaConfig");

	public static void main(String[] args) {
		System.out.println("hello");
	}

}
