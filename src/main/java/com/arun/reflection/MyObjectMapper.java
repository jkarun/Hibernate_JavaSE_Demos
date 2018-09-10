package com.arun.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MyObjectMapper {

	private static final String GET_TYPE = "get";
	private static final String SET_TYPE = "set";
	
	public static void main(String[] args) throws InterruptedException {
		MyObjectMapper mapper = new MyObjectMapper();
		
		Method[] declaredMethods = ReflectionBasics.class.getDeclaredMethods();
		HashMap<String, Method> getMap = mapper.getGetSetMethodMap(declaredMethods, GET_TYPE);
		HashMap<String, Method> setMap = mapper.getGetSetMethodMap(declaredMethods, SET_TYPE);
		
		System.err.println("Getter methods:");
		getMap.entrySet().forEach(a -> {
			System.out.println( a.getKey() + " :: " + a.getValue());
		});
		
		Thread.sleep(100);
		
		System.err.println("Setter methods:");
		setMap.entrySet().forEach(a -> {
			System.out.println( a.getKey() + " :: " + a.getValue());
		});
	}

	private HashMap<String, Method> getGetSetMethodMap(Method[] declaredMethods,String type){
		HashMap<String, Method> map = null;
		
		List<Method> getterList = Arrays.stream(declaredMethods).filter(a -> a.getName().startsWith(type))
				.collect(Collectors.toList());

		map = getterList.stream().collect(
				HashMap<String, Method>::new, (m, c) -> m.put(c.getName(), c),
				(m, u) -> {}
		);
		
		return map;
	}

}
