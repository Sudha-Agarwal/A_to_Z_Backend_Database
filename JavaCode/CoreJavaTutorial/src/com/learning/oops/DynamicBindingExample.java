package com.learning.oops;

class Person {
	String name; //2 bytes
	int age; //4 bytes		
	
	int var = 10;
	
	Person(String name, int age){
		System.out.println("parent class person's constructor");
		if(age < 0) {
			System.out.println("age cannot be less than 0");			
		}
		else {
			this.name = name;
			this.age = age;	
		}			
	}
	
	Person(){
		super();		
	}
	
	long displayDetails() {
		System.out.println("parent method");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		return 0l;
		
	}
	
	static void staticMethod() {
		System.out.println("static Parent Method");
	}
}

class Employee extends Person{
	int empId;
	String department;
	
	int var = 20;
	
	Employee(String name, int age,int empId){
		super(name, age);
		this.empId = empId;
		
	}
	
	Employee(){
		
	}
	//Annotations	
	@Override
	public long displayDetails() {
		System.out.println("Employee child method");
		System.out.println("Name: " + name);	
		System.out.println("Age: " + age);	
		System.out.println("Emp Id: " + empId);	
		return 0;
		
	}
	
	public void showChild() {
		System.out.println("show child method");
	}
	
	static void staticMethod() {
		System.out.println("static child Method");
	}
	
}

class adminEmployee extends Employee{
	public adminEmployee() {
		super();
	}
}

class Student extends Person{
	int rollNo;
	
	Student(int rollNo){
		this.rollNo = rollNo;
	}
	

	public long displayDetails() {
		System.out.println("student child method");
		System.out.println("Emp Id: " + rollNo);	
		return 0;
		
	}
	

}

public class DynamicBindingExample{
	public static void main(String[] args) {
		Person obj = new Person("Sudha",30);
		//obj.displayDetails();
		
		Person obj1 = new Employee("Sudha",30,1);
		//obj1.displayDetails();
		
		Person obj2 = new Student(123);
		//obj1.showChild();		
		
		//displayPersonDetails(obj1);
		//System.out.println("--------------------");
		//displayPersonDetails(obj2);
		
		System.out.println(obj.var);
		System.out.println(obj1.var);
		
		obj.staticMethod();
		obj1.staticMethod();
		
		int a = 10;
		//PassByValue(a);
		//System.out.println("original " + a);	
		
		Employee e = new Employee("sudha",30,1);
		System.out.println("before " + e.empId);
		passByReference(e);
		System.out.println("After " + e.empId);
		
		

	
		
	}
	
	private static void displayPersonDetails(Person person) {
		person.displayDetails();
	}	
	
	public static void PassByValue(int a) {
		a++;
		System.out.println("modified " + a);
	}
	
	public static void passByReference(Employee e) {
		e.empId = 2;
	}
}
