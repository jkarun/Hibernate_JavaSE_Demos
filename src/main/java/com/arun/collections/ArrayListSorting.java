package com.arun.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting {

	public static void main(String[] args) {
		ArrayListSorting obj = new ArrayListSorting();
		obj.test1();
	}

	private void test1(){
		ArrayList<Integer> a = new ArrayList<>();
		//IntStream.range(1, 10).forEach(a::add); // add elements
		int x=10;
		while (x > 0){
			a.add(x);
			x--;
		}
		System.out.println("Actual Array :");
		a.stream().forEach(System.out::print);
		
		System.out.println("\nAfter sorting : Asc order");
		Collections.sort(a, (l1, l2) -> l1.compareTo(l2));
		a.stream().forEach(System.out::print);
		
		System.out.println("\nActual Array :");
		a.stream().forEach(System.out::print);
		
		System.out.println("\nAfter sorting : Desc order");
		Collections.sort(a, (l1, l2) -> l2.compareTo(l1));
		a.stream().forEach(System.out::print);
	}
}
