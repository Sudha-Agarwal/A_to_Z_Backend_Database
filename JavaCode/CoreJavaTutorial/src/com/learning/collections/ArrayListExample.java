package com.learning.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//Adding elements
		list.add("Java");
		list.add("Python");
		list.add("C++");	
		list.add("C++");	
		
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(Integer.valueOf(1));
		numberList.add(2);
		numberList.add(3);
		numberList.add(4);
		//numberList.remove(0);
		
		System.out.println(numberList);
		
		System.out.println("-----Reverse-------");
		Collections.reverse(numberList);
		System.out.println(numberList);
		
		System.out.println("Checking if 5 is there " + numberList.contains(5));
		
		
		System.out.println(list.get(0));
		
		System.out.println(list);
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		
		
	}

}
