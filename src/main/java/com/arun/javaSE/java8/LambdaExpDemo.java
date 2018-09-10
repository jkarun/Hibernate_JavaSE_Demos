package com.arun.javaSE.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.arun.hql.Employee;
import com.arun.javaSE.java8.functionaInterfaces.MathOpp;

public class LambdaExpDemo {

	public static void main(String[] args) {
		System.out.println("Math Opperation start*******************");
		MathOpp add = (a, b) -> a + b;
		MathOpp multi = (a, b) -> a * b;
		MathOpp anonyms = (a,b) -> {
			System.out.println("Annonyms calling : ");
			return a+b;
		};
		
		
		System.out.println("addition : " + add.doMathOperation(10, 20));
		System.out.println("multiplication : " + multi.doMathOperation(10, 20));
		System.out.println("multiplication : " + anonyms.doMathOperation(10, 20));
		System.out.println("Math Opperation end*******************\n");

		System.out.println("List sorting start*******************\n");
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "Pardeep", 2900));
		list.add(new Employee(2, "Ravi", 3400));
		list.add(new Employee(3, "Robert", 2000));
		list.add(new Employee(4, "Smith", 3400));
		list.add(new Employee(5, "Agtha", 2300));

		System.out.println("befor sorting : ");
		list.stream().forEach(System.out::println);
		Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()));
		System.out.println("After sorting by name : ");
		list.stream().forEach(System.out::println);
		System.out.println("List sorting end*******************\n");
	}

}
