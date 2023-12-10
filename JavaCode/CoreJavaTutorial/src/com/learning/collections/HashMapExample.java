package com.learning.collections;

import java.util.HashMap;

public class HashMapExample {
	
	public static void main(String[] args) {
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		map.put(1,new Employee(1,"ABC1"));
		map.put(2,new Employee(2,"ABC1"));
		map.put(3,new Employee(1,"ABC1"));
		
		System.out.println(map);
		
		
		
	}

}
