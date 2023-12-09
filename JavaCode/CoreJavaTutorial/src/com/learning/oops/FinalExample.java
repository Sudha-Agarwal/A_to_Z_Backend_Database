package com.learning.oops;

class FinalClass{
	final int finalVar;
	
	FinalClass(){
		finalVar = 42;
	}
	
	final void finalMethod() {
		System.out.println("Final method");
		finalVar = 40;
	}
	
}

class child extends FinalClass{
	void finalMethod(){
		
	}
	
}

public class FinalExample {

}
