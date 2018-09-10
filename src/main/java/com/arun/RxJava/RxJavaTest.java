package com.arun.RxJava;

import java.util.function.Consumer;

import io.reactivex.Observable;

public class RxJavaTest {

	public static void main(String[] args) {
		RxJavaTest test = new RxJavaTest();
		test.basicRxJava();
	}

	String result = "";

	private void basicRxJava() {// producer
		Observable<String> observable = Observable.just("how", "to", "do", "in", "java");

		// consumer
		Consumer<? super String> consumer = System.out::println;

		// Attaching producer to consumer
		observable.subscribe(consumer);
	}
}
