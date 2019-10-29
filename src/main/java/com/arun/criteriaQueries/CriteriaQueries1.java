package com.arun.criteriaQueries;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.arun.helloworld.Employee;
import com.arun.util.HibernateUtil;

public class CriteriaQueries1 {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getJavaConfigSessionFactory().openSession()) {
			System.out.println("Using java cofig session factory");
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> employee = query.from(Employee.class);
			query.select(employee);
			System.out.println(employee.getClass().getName());
			// old way
			System.out.println("using old fashion query ");
			Query<Employee> q = session.createQuery("from Employee");
			List<Employee> employees = q.getResultList();
			employees.forEach(e -> System.out.println(e));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getJavaConfigSessionFactory();
		}
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			System.out.println("Using standerd cofig session factory");
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee").getResultList();
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
