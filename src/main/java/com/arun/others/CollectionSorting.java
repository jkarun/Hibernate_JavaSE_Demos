package com.arun.others;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionSorting {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("arun");
		list.add("cj");
		list.add("jk");
		list.add("sanju");

		Collections.sort(list, (a, b) -> a.length() - b.length());
		list.stream().forEach(System.out::println);
		
		Collections.sort(list);
		list.stream().forEach(System.out::println);
	}

}

