package multithreading;


@FunctionalInterface
interface myFunctionalInterface{
	void myMethod(String message);
	
	default void myMethod2() {
		
	}
}

class InterfaceImplementor implements myFunctionalInterface{

	@Override
	public void myMethod(String message) {
		System.out.println(message);
	}
	
}


public class FunctionalInterfaceRunner {
	public static void main(String[] args) {
		myFunctionalInterface obj = new InterfaceImplementor();
		obj.myMethod("Hello World");
		
		myFunctionalInterface obj1 =  message -> System.out.println(message);		
		obj1.myMethod("Anonymous class");
		
		
	}
	

}
