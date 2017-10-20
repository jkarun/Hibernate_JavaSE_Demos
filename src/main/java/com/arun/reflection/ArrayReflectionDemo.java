package com.arun.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class ArrayReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		ArrayReflectionDemo obj = new ArrayReflectionDemo();
		obj.printArrayBasics();
		obj.printClassArray();
	}
	
	private void printClassArray() throws ClassNotFoundException {
		String[] strings = new String[3];
		Class stringArrayClass = strings.getClass();
		Class stringArrayComponentType = stringArrayClass.getComponentType();
		System.out.println(stringArrayComponentType);
		
		System.out.println("class.forname for int arry");
		Class intClass1 = Class.forName("[I"); //like this we can obtain other object arrays using this
		Class stringArray = String[].class;
		System.out.println(intClass1.getName());
		System.out.println(stringArray.getName());
	}

	private void printArrayBasics(){
		//create array
		int[] a = (int[]) Array.newInstance(int.class, 3);
		Array.set(a, 0, 1);
		Array.set(a, 1, 3);
		Array.set(a, 2, 5);
		Arrays.stream(a).forEach(System.out::println);
		
		System.out.println("\nAccessing array:\n");
		System.out.println("a[0]=" + Array.get(a,0));
		System.out.println("a[1]=" + Array.get(a,1));
		System.out.println("a[2]=" + Array.get(a,2));
	}
}
