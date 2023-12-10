package com.learning.collections;

import java.util.HashSet;

class Employee{
	int empId;
	String name;
	
	Employee(int empId, String name){
		this.empId = empId;
		this.name = name;
	}
	@Override
	public int hashCode() {
		System.out.println("hashcode method called");
		System.out.println("Hashcode: " + name.hashCode());
		return name.hashCode();		
	}
	@Override
	public boolean equals(Object obj) {
		Employee employee = (Employee)obj;
		System.out.println("equals called");
		
		if(employee.empId == this.empId) return true;
		else
			return false;
		
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	
	
}

public class HashSetEmployeeExample {
	public static void main(String[] args) {
		HashSet<Employee> set = new HashSet<Employee>();
		
		Employee e1 = new Employee(1, "ABC1");
		Employee e2 = new Employee(2, "ABC2");
		Employee e3 = new Employee(3, "ABC1");
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		
		//System.out.println(set);
		System.out.println("----Searching-------");
		Employee searchEmployee = new Employee(3, "ABC2");
		
		if(set.contains(searchEmployee))
			System.out.println("found");
		else
			System.out.println("Not found");
		
		
	}

}
