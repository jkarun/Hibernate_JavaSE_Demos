package com.arun.javaSE.collectionsDemo.whiteData;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		p.isPalindrome("amma");
		p.isPalindrome("arun");
		p.isPalindrome("jaay");
		p.isPalindrome("madam");
		p.isPalindrome("arun prasath");
	}
	
	private void isPalindrome(String str){
		List<Character> list = new LinkedList<Character>();
		for(char a : str.toCharArray())
			list.add(a);
		
		ListIterator<Character> a = list.listIterator();
		ListIterator<Character> b = list.listIterator(str.length());
		
		boolean result = true;
		while (a.hasNext() && b.hasPrevious()){
			if(a.next() != b.previous()){
				result = false;
				break;
			}
		}
		System.out.println(str+" : " +(result ? "String is palindrome" : "String is not palindrome"));
	}
}
