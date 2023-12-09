package com.learning.oops;

class Example{
	int x;
	static int y;
	
	{
		x = 10;
		System.out.println("Instance Initialization block");
	}
	
	//Static Initialization Block(SIB)
	static {
		y = 20;
		System.out.println("Static Initialization block1");
	}
	
	static {
		y = 30;
		System.out.println("Static Initialization block2");
	}
	
	Example(){
		System.out.println("constructor");
	}
	
	
}
public class InitializerBlock {
	public static void main(String[] args) {
		Example e  = new Example();
		System.out.println(Example.y);
		
	}

}
