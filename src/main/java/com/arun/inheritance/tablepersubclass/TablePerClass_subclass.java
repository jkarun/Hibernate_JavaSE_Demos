package com.arun.inheritance.tablepersubclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.arun.util.HibernateUtil;

public class TablePerClass_subclass {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		Emp_subclass e1=new Emp_subclass();  
	    e1.setName("sonoo");  
	      
	    RegularEmp_subclass e2=new RegularEmp_subclass();  
	    e2.setName("Vivek Kumar");  
	    e2.setSalary(50000);  
	    e2.setBonus(5);  
	      
	    ContractEmp_subclass e3=new ContractEmp_subclass();  
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
