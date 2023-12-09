package com.learning.oops;

interface Movable{
	int x =10;
	void move();
	void move1();
}

class Dog1 implements Movable, {
	@Override
	public void move() {
		
		System.out.println("dog is moving");
	}
	
}

class Vehicle{
	
}

class Car extends Vehicle implements Movable{
	public void move() {
		System.out.println("car is moving");
	}
	public void move1() {
		System.out.println("car is moving");
	}
	
}

public class InterfaceExample {

}
