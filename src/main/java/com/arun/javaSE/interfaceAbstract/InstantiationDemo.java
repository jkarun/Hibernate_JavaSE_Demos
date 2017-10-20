package com.arun.javaSE.interfaceAbstract;

public class InstantiationDemo {
	public static void main(String[] args) {
		testInterface a = new testInterface();
		a.printClassString("test string for interface print method");
		a.printString();
		a.pritnClass("test string for abstract class print method");

		Inter b = new Inter() {
			public void printClassString(String str) {
				System.out.println(str);
			}
		};
		b.printClassString("annonymus interface string");

		AbstractClass c = new AbstractClass() {
			@Override
			void pritnClass(String str) {
				System.out.println(str);
			}
		};
		c.pritnClass("annonymus abstract string");

		System.err
				.println("Note: Cannot Instantiation of interface and abstract class driectly but can annonymus method."
						+ "\nFor ex: not possible following instantiation "+"Inter d = new Inter();"+"\nAbstractClass e = new AbstractClass();");
		// Inter d = new Inter();
		// AbstractClass e = new AbstractClass();
	}
}

class testInterface extends AbstractClass implements Inter {
	@Override
	public void printClassString(String str) {
		System.out.println(str);
	}

	@Override
	void pritnClass(String str) {
		System.out.println(str);
	}
}
