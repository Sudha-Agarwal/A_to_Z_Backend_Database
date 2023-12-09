package com.learning.oops;

public class StaticExample {
	
	static int staticVariable = 10;
	int nonStaticVariable = 20;
	static int counter = 0;
	
	public StaticExample() {
		counter++;
	}
	
	void changeStatic() {
		staticVariable ++;
		//System.out.println(staticVariable);
	}
	
	void changeNonStatic() {
		nonStaticVariable++;
		//System.out.println(nonStaticVariable);
		staticMethod();
	}
	
	static void staticMethod() {
		System.out.println("Static method");	
		//changeNonStatic();
		
	}	
	
	public static void main(String[] args) {		
		System.out.println(StaticExample.staticVariable);
		
		StaticExample obj1 = new StaticExample();
		//obj1.changeStatic();
		obj1.changeNonStatic();
		
		StaticExample obj2 = new StaticExample();
		obj2.changeNonStatic();		
		//obj2.changeStatic();
		
		StaticExample obj3 = new StaticExample();
		
		System.out.println(obj1.nonStaticVariable);
		System.out.println(obj2.nonStaticVariable);
		
		System.out.println("No of objects created " + counter);
		
		StaticExample.staticMethod();
		
		
		
	}

}
