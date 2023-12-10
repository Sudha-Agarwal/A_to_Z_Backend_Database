package com.learning.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Person implements Comparable<Person>{
	int age;
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		System.out.println("compare to called");
		System.out.println("Current Object: " + this.name);
		System.out.println("Object being compared: " + o.name);
		
		if(this.age < o.age) return -1;
		else if (this.age > o.age) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "Person [name= " + name + ", age= " + age + "]";
	}
}

class DescendingComaparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		 return o1.name.compareTo(o2.name);
		
	}
	
}
public class PersonSortingComparable {
	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person(20,"ABC"));
		list.add(new Person(30,"DABC1"));
		list.add(new Person(25,"BABC2"));
		list.add(new Person(35,"CABC3"));
		
		System.out.println(list);
		Collections.sort(list, new DescendingComaparator());
		
		System.out.println(list);
		
	}

}
