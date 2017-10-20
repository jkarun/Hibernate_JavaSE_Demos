package com.arun.javaSE.innerClasses;

public class InnerClassBasic {
	private String str = "Global InnerClassBasic String";
	private final String str1 = "Global final String for member inner class";
	private static String str2 = "Global String for static inner class";
	
	class innerClass{
		private String a = "from InnerClass";
		public void printInnerClass(String s){
			System.out.println(s);
		}
	}
	
	static class staticInnerClass{
		private String strIn="default static inner class var";
		public void printStaticInner(){
			System.out.println(str2+", "+strIn );
		}
	}
	
	public void memberInnerClassMethod(final String a1, String a2){
		class memberInnerClass{
			public void printMemberInnerMethod(){
				System.out.println("from member inner class "+a1+", " + a2);
				System.err.println("from java 8 member inner class can also acces non final variables.");
			}
		}
		memberInnerClass mInnerObj = new memberInnerClass();
		mInnerObj.printMemberInnerMethod();
	}
	public static void main(String [] args){
		InnerClassBasic globalObj = new InnerClassBasic();
		globalObj.printInnerClassBasic();
		
		innerClass innerObj = globalObj.new innerClass();
		innerObj.printInnerClass(innerObj.a);
		System.out.println(innerObj.a);
		
		globalObj.memberInnerClassMethod(globalObj.str1, "non final string");
		
		staticInnerClass staticObj = new InnerClassBasic.staticInnerClass();
		staticObj.printStaticInner();
		
		innerClass ano = globalObj.new innerClass(){
			public void printInnerClass(String s){
				System.out.println(s);
			}
		};
		ano.printInnerClass("from annonymus inner class");
		
	}
	
	public void printInnerClassBasic(){
		System.out.println(this.str);
	}
}
