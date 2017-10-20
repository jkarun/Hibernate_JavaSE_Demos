package com.arun.javaSE.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsDemo {
	List<Person> list = new ArrayList<>();

	private void test() {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dd");
		List<String> resultList = list.stream().collect(Collectors.toList());
		Set<String> resultSet = list.stream().collect(Collectors.toSet());
		System.err.println("Collectors.toList()");
		resultList.forEach(System.out::println);
		System.err.println("Collectors.toSet()");
		resultSet.forEach(System.out::println);
	}

	private void test2() {
		System.err.println("Collectors.groupingBy");
		Map<Integer, List<Person>> personsByAge = list.stream().collect(
				Collectors.groupingBy(p -> p.getAge()));
		personsByAge.forEach((age, p) -> System.out.format(
				"Person age %s: %s\n", age, p));

		System.err.println("Collectors.averagingInt");
		Double ageAverage = list.stream().collect(
				Collectors.averagingInt(p -> p.getAge()));
		System.out.println("Average age of all persons :" + ageAverage);

		System.err.println("Collectors.averagingInt");
		IntSummaryStatistics summary = list.stream().collect(
				Collectors.summarizingInt(p -> p.getAge()));
		System.out.println("Average age of all persons :" + summary);

		System.err.println(" joins all persons into a single string");
		String text = list.stream().filter(p -> p.getAge() >= 5)
				.map(p -> p.getName()).collect(Collectors.joining());
		System.out.println("joining persons :" + text);

		System.err.println(" joins all persons into a single string");
		String text2 = list
				.stream()
				.filter(p -> p.getAge() >= 2)
				.map(p -> p.getName())
				.collect(
						Collectors.joining(", ", "In india ",
								" are of legal age."));
		System.out.println("joining persons :" + text2);
	}

	private void test3(){
		System.err.println("Collectors.toMap");
		Map<Integer, String> map = list.stream().filter(p -> p.getAge() >= 5).collect(Collectors.toMap(p -> p.getAge(), p -> p.getName(), 
				(name1,name2)-> name1+" ; "+name2 ));
		System.out.println(map);
	}
	
	private void setPersonList() {
		Person a = new Person(1, "arun");
		Person b = new Person(2, "agi");
		Person c = new Person(3, "nura");
		Person d = new Person(3, "jk");
		Person e = new Person(2, "jaya");
		Person f = new Person(5, "praba");
		Person g = new Person(8, "sathya");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);
		list.add(a);
		list.add(a); // duplicate
	}

	public static void main(String[] args) {
		CollectorsDemo demo = new CollectorsDemo();
		demo.setPersonList();
		demo.test();
		demo.test2();
		demo.test3();
	}
}
