package com.arun.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class ReflectionBasics {

	public int no;
	public String str;
	public long lng;
	public double dobl;
	public static ReflectionBasics obj;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public long getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	public double getDobl() {
		return dobl;
	}

	public void setDobl(double dobl) {
		this.dobl = dobl;
	}

	public static ReflectionBasics getObj() {
		return obj;
	}

	public static void setObj(ReflectionBasics obj) {
		ReflectionBasics.obj = obj;
	}

	public void method1() {
	}

	protected void method2() {
	}

	void method3() {
	}

	private String method4() {
		System.out.println("method4 inside output line");
		return "method4";
	}

	public ReflectionBasics() {
	}

	public ReflectionBasics(Integer n) {
		no = n;
	}

	public ReflectionBasics(String s) {
		str = s;
	}

	public ReflectionBasics(Long l) {
		lng = l;
	}

	public ReflectionBasics(Double d) {
		dobl = d;
	}

	public ReflectionBasics(String s, Integer n) {
		str = s;
		no = n;
	}

	private void printArrays(Object[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		obj = new ReflectionBasics();
		System.out.println("Reflections Demo program \nNote : private method or fields will not be dispalyed. \n\n");
		System.out.println("Printing basics reflection in class\n");
		obj.printBasics();
		System.out.println("\nPrinting methods in class\n");
		obj.printMethods();
		System.out.println("\nPrinting constructors in class\n");
		obj.printConstructors();
		System.out.println("\nPrinting fields: \n");
		obj.printFields();
	}

	public void printBasics() {
		Class c = obj.getClass();
		System.out.println(c.getCanonicalName());
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		System.out.println(c.getModifiers());

	}

	private void printMethods() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = obj.getClass();
		Method[] methods = c.getMethods();
		this.printArrays(methods);
		/*
		 * If the method you are trying to access takes no parameters, pass null
		 * as the parameter type array, like this:
		 * 
		 * Class aClass = ...//obtain class object Method method =
		 * aClass.getMethod("doSomething", null);
		 */
		Method m4 = c.getDeclaredMethod("method4", null);
		System.out.println("\nMethods return types of method4 = " + m4.getReturnType());
		System.out.println("Accessing private method field and invoiking:\n");
		m4.setAccessible(true);
		m4.invoke(this, null);
	}

	private void printConstructors() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = obj.getClass();
		Constructor[] cons = c.getConstructors();
		System.out.println("print all constructors");
		this.printArrays(cons);

		Constructor cons2 = c.getConstructor(new Class[] { String.class, Integer.class });
		System.out.println("\nprinting String and Int constructor name : \n" + cons2.getName() + " \nparameter count = "
				+ cons2.getParameterCount());
		Class[] cons2Types = cons2.getParameterTypes();
		System.out.println("parameters of string constructor : ");
		this.printArrays(cons2Types);

		System.out.println("\nIntialize obj with string and int constructor : \n");
		ReflectionBasics obj2 = (ReflectionBasics) cons2.newInstance("constructor string", 63);
		System.out.println(
				"Object is intialized and their values : \nString = " + obj2.getStr() + ", int = " + obj2.getNo());
	}

	private void printFields() throws NoSuchFieldException, SecurityException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = obj.getClass();
		Field[] f = c.getFields();
		this.printArrays(f);
		Field f2 = c.getField("dobl");
		System.out.println("\nprint double field name : " + f2.getName() + ", field type : " + f2.getType() + "\n");

		System.out.print("Setting value : 33.66 and getting this value = ");
		ReflectionBasics ref = new ReflectionBasics(33.66);
		f2.set(ref, 33);
		System.out.println(f2.get(ref));

		System.out.println(
				"It the field is a static field (public static ...) pass null as parameter to the get and set methods, instead of the object parameter");

	}

}
