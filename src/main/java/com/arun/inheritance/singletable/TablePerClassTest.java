package com.arun.inheritance.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arun.util.HibernateUtil;

public class TablePerClassTest {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		Employee_singletable e1=new Employee_singletable();  
	    e1.setName("sonoo");  
	      
	    Regular_employee e2=new Regular_employee();  
	    e2.setName("Vivek Kumar");  
	    e2.setSalary(50000);  
	    e2.setBonus(5);  
	      
	    Contract_emp e3=new Contract_emp();  
	    e3.setName("Arjun Kumar");  
	    e3.setPay_per_hour(1000);  
	    e3.setContract_duration("15 hours");  
	      
	    session.persist(e1);  
	    session.persist(e2);  
	    session.persist(e3);  
		
	    session.getTransaction().commit();
	    session.close();
	    
	}

}
