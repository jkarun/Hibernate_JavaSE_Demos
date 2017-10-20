package com.arun.hql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.arun.util.HibernateUtil;

public class CriteriaBasic {

	public static SessionFactory sessionFactory;

	public static void main(String[] args) {
		sessionFactory = HibernateUtil.getSessionFactory();
		CriteriaBasic cb = new CriteriaBasic();
		cb.basicQuery();
		System.exit(0);
	}

	@SuppressWarnings("unchecked")
	public void basicQuery() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Criteria cr = session.createCriteria(Employee.class);
			cr.setFirstResult(1);
			cr.setMaxResults(5);
			List<Employee> list = new ArrayList<>();
			
			list = cr.add(Restrictions.gt("salary", 50000)).list();
			this.printList(list, "Greater than");
			list.clear();

			list = cr.add(Restrictions.lt("salary", 50000)).list();
			this.printList(list, "Less than");
			list.clear();
			
			Employee emp = (Employee) cr.add(Restrictions.eq("salary", 10000)).uniqueResult();
			System.out.println(emp);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printList(List<Employee> list,String title) {
		System.out.println("------------------"+title+"------------------");
		if (list.isEmpty())
			System.out.println("list is empty");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		System.out.println("-----------------------------------------\n");
	}
}
