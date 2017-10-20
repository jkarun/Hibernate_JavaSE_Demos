package com.arun.javaSE.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PremitiveStreamsDemo {
	private int[] intArray = new int[]{1,2,3,4,5,6,7,8,9};
	
	private void test1(){
		System.out.println("Stream.of integers findFirst()");
		Stream.of(1,2,3,4,5).findFirst().ifPresent(System.out::println);
		System.out.println("Stream.of int array findFirst()");
		Stream.of(intArray).findFirst().ifPresent(System.out::println);
		
		System.out.println("Arrays.Stream int array findFirst()");
		Arrays.stream(intArray).findFirst().ifPresent(System.out::println);
		System.out.println("Arrays.Stream int array average()");
		Arrays.stream(intArray).average().ifPresent(System.out::println);
		System.out.println("IntStream.range(1, 10)");
		IntStream.range(1, 10).forEach(System.out::print);
		
		System.out.println("\nmapToInt()");
		Stream.of("a1","a2","a3","a4").map(s->s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::print);
		System.out.println("\nmapToObj()");
		Stream.of(1,2,3,4,5).mapToInt(Integer::valueOf).mapToObj(s->"a"+s).forEach(System.out::println);
	}
	public static void main(String[] args) {
		PremitiveStreamsDemo demo = new PremitiveStreamsDemo();
		demo.test1();
	}
}
