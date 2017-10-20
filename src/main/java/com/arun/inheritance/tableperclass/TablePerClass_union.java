package com.arun.inheritance.tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.arun.util.HibernateUtil;

public class TablePerClass_union {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		Emp_perclass_union e1=new Emp_perclass_union();  
	    e1.setName("sonoo");  
	      
	    RegularEmp_perclass_union e2=new RegularEmp_perclass_union();  
	    e2.setName("Vivek Kumar");  
	    e2.setSalary(50000);  
	    e2.setBonus(5);  
	      
	    ContractEmp_perclass_union e3=new ContractEmp_perclass_union();  
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
