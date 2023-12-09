package com.learning.oops;


abstract class Animal{
	abstract void makeSound();
	void sleep() {
		
	}
}

class Dog extends Animal{
	void makeSound() {
		System.out.println("bark");
	}
}

class Cat extends Animal{
	void makeSound() {
		System.out.println("meow");
	}
}
public class AbstractClassExample {
	public static void main(String[] args) {
		//Animal obj = new Animal();
		Animal dog1 = new Dog();
		dog1.makeSound();
		
		Animal cat1 = new Cat();
		cat1.makeSound();
		
	}

}
