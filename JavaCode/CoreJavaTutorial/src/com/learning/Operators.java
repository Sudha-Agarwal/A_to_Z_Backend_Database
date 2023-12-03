package com.learning;

public class Operators {
	//method overloading	
	static void print(int a, int b) {
		System.out.println("long paramters");		
	}
	
	static void print(long a, long b) {
		System.out.println("long paramters");		
	}
	
	static void print(long a, long b, long c) {
		System.out.println("long paramters");		
	}
	
	int multiply(int a) {
		return a * a;
		
	}
	
	int multiply(int a, int b) {
		return a *b;
		
	}
	
	public static void main(String[] args) {
		print(2,3l);//calling method
		
		int x = 11;
		int y = 20;
		
		System.out.println(!(x == 10 || x > y ));
		
		String result = (x % 2 == 0) ? "Even": "odd";
		System.out.println(result);
		
		//type casting - assigning a value of one primitive type to another type
		
		/*we have two types of casting:
			1. widening casting/upcasting (automatically)
			this is done when we are assigning a smaller type to larger type
			int i = 10;
			double d = i;
			
			2. narrowing casting/downcasting(manually)
		*/
		
		byte i = (byte)1000;
		float d = i;//automatic casting
		int i1 = (int)10.89f; //manual casting
		System.out.println(i);
		
	}


}
