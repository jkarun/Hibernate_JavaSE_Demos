package com.arun.associtation.oneToMany.foreignkey.Bidirectional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arun.util.HibernateUtil;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();

		Student_otm_fkey student1 = new Student_otm_fkey("Sam", "Disilva",
				"Maths");
		Student_otm_fkey student2 = new Student_otm_fkey("Joshua", "Brill",
				"Science");
		Student_otm_fkey student3 = new Student_otm_fkey("Peter", "Pan",
				"Physics");

		University_otm_fkey university = new University_otm_fkey("CAMBRIDGE",
				"ENGLAND");
		List<Student_otm_fkey> allStudents = new ArrayList<Student_otm_fkey>();

		student1.setUniversity(university);
		student2.setUniversity(university);
		student3.setUniversity(university);

		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);

		university.setStudent(allStudents);

		session.persist(university);// Students will be presisted automatically,
									// thanks to CASCADE.ALL defined on students
		// property of University class.

		List<Student_otm_fkey> students = (List<Student_otm_fkey>) session
				.createQuery("from Student_otm_fkey ").list();
		for (Student_otm_fkey s : students) {
			System.out.println("Student Details : " + s);
			System.out.println("Student University Details: "
					+ s.getUniversity());
		}

		// Note that now you can also access the relationship from University to
		// Student

		session.getTransaction().commit();
		session.close();
	}

}
