package com.arun.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
@MyAnnotation(name = "Arun", value = "Hello Arun...")
public class AnnotationDemo {
	public static AnnotationDemo obj;

	@MyAnnotation(name = "Field", value = "feild annotation value")
	public String str;

	private void printArrays(Object[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		obj = new AnnotationDemo();
		obj.printAnnotationBasics();
	}

	public void printAnnotationBasics() throws NoSuchFieldException, SecurityException {
		Class c = obj.getClass();
		System.out.println("Print annotations used: \n");
		Annotation[] an = c.getAnnotations();
		this.printArrays(an);

		System.out.println("\nprint annotaion name and value:\n");
		Annotation[] an2 = c.getAnnotations();
		Arrays.stream(an2).forEach(a -> {
			if (a instanceof MyAnnotation) {
				MyAnnotation my = (MyAnnotation) a;
				System.out.println("name : " + my.name() + ", Value: " + my.value());
			}
		});

		
		System.out.println("\nprint Field annotaion name and value:\n");
		Field f = c.getDeclaredField("str");
		Annotation an3 = f.getAnnotation(MyAnnotation.class);
			if (an3 instanceof MyAnnotation) {
				MyAnnotation my = (MyAnnotation) an3;
				System.out.println("name : " + my.name() + ", Value: " + my.value());
			}
	}
}
