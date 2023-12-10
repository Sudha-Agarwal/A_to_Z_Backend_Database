package com.learning.collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		Set<String> treeSet = new TreeSet<String>();
		
		treeSet.add("Banana");
		treeSet.add("Apple");
		treeSet.add("Mango");
		treeSet.add("Grapes");
		treeSet.add("Grapes");
		
		System.out.println(treeSet);
	}

}
