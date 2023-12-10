package com.learning.collections;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("Python");
		set.add("C");
		set.add("C++");
		set.add("c++");
		
		System.out.println(set);
		
		set.remove("java");
		
		System.out.println(set);
	}
	

}
