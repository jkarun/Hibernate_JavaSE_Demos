package com.arun.javaSE.collectionsDemo.whiteData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.arun.helloworld.Employee;

public class FirstRound implements GenericInterface<Employee>{

	public static void main(String[] args) {
		new FirstRound().printList();
	}

	@Override
	public Employee printList() {
		List<Employee> list = new ArrayList<Employee>();

		Employee a = new Employee();
		a.setId(1);a.setName("arun");
		Employee b = new Employee();
		b.setId(2);b.setName("nura");	
		Employee c = new Employee();
		c.setId(3);c.setName("java");
		Employee d = new Employee();
		d.setId(4);d.setName("world");
		Employee e = new Employee();
		e.setId(5);e.setName("hai");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		
		System.out.println("before sorting...");
		for(Employee emp : list)
			System.out.println(emp);
		
		System.out.println("\nafter sorting...");
		/*Collections.sort(list,Collections.reverseOrder());
		for(Employee emp : list)
			System.out.println(emp);*/
		
		list.sort(Comparator.comparing(Employee::getName));
		for(Employee emp : list)
			System.out.println(emp);
		
		System.out.println("\nafter revers sorting...");
		list.sort(Comparator.comparing(Employee::getName).reversed());
		for(Employee emp : list)
			System.out.println(emp);
		
		System.out.println("\nusing stream() with sort");
		list.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
		
		System.out.println("with limit and distinct--------------   ");
		list.stream().limit(3).distinct().forEach(j -> System.out.println(j));
		System.out.println("with filter -------------");
		list.stream().filter(i -> i.getId() > 3).forEach(System.out::println);
		System.out.println(list.stream().distinct().count());
		return null;
	}

}
