package com.arun.javaSE.java8;

public class MethodReferencesTest {

	public static void main(String[] args) {
	}

	private static void refObj(test1 obj) {
	}

}

class test1 {
	public static String method1() {
		return "test1::method1";
	}

	public static void method2(String str) {
		System.out.println("test1::method2 : " + str);
	}

}