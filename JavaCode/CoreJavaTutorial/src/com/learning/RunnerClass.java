package com.learning;

public class RunnerClass {
	public static void main(String args[]) {
		//we create an object of class person using a keyword called 'new';
		Person obj1 = new Person();
		//obj1.age = 30;
		obj1.name = "Sudha";
		//obj1.salary = 2000.88f;
		obj1.gender = 'F';
		//obj1.isAdmin = true;
		
		Person obj2 = new Person("ABC", 40);
		//obj2.age = -40;
		obj2.name = "ABC";
		
		obj1.speak();// to call behavior method
		obj2.speak();
		
		System.out.println(obj2.getAge());
		
		Employee e1 = new Employee("ABC",40,123, "IT");
		System.out.println(e1.name);
		
		Student s1 = new Student("ABC1", 18, 111, "MCA");
		System.out.println(s1.name);
		
		s1.show();
		
		Person p1= new Person("ABC2", 25);
		p1.show();
		
		Person e2 = new Employee("ABC",40,123, "IT");
		e2.show();
		
		//Employee e3 = (Employee) new Person(); - not to be done
		
		
		
	}

}
