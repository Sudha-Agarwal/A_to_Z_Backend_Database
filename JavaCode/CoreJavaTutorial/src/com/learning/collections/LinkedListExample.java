package com.learning.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Apple");
		list.add("banana");
		list.add("orange");
		
		list.addFirst("Mango");
		list.addLast("Melon");
		
		
		System.out.println(list.get(2));
		
		list.remove("banana");
		list.remove(0);
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		 System.out.println(list);
		 
		 list.add(1, "WaterMelon");
		 
		 System.out.println(list);
		
	}
	

}
